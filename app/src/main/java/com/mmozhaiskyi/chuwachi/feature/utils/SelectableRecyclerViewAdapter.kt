package com.mmozhaiskyi.chuwachi.feature.utils

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

enum class SelectedStrategy { ONE, FEW }

abstract class SelectableViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: T, isSelected: Boolean)
}

class SingleTypeViewHolderFactory<T>(private val provider: (ViewGroup) -> SelectableViewHolder<T>) : ViewHolderFactory<T> {

    override fun createViewHolder(parent: ViewGroup, viewType: Int): SelectableViewHolder<T> {
        return provider.invoke(parent)
    }
}

interface ViewHolderFactory<T> {

    fun getViewType(position: Int): Int = 0

    fun createViewHolder(parent: ViewGroup, viewType: Int = 0): SelectableViewHolder<T>
}

open class SelectableRecyclerViewAdapter<T>(
    private val items: List<T>,
    private val strategy: SelectedStrategy,
    private val viewHolderFactory: ViewHolderFactory<T>,
    private val selectedItemsChanges: (List<T>) -> Unit,
    private val defaultSelectedPositions: List<Int> = listOf()
) : RecyclerView.Adapter<SelectableViewHolder<T>>() {

    init {
        val defaultSelectedItems = defaultSelectedPositions.map { position -> items[position] }
        selectedItemsChanges.invoke(defaultSelectedItems)
    }

    private val selectedItemsPositions = mutableSetOf<Int>().apply {
        addAll(defaultSelectedPositions)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectableViewHolder<T> {
        return viewHolderFactory.createViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SelectableViewHolder<T>, position: Int) {
        val item = items[position]
        val isSelected = selectedItemsPositions.contains(position)
        holder.bind(item, isSelected)

        holder.itemView.setOnClickListener {
            handleItemClick(position)
            emitSelectedChanges()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewHolderFactory.getViewType(position)
    }

    private fun handleItemClick(position: Int) {
        val isSelected = selectedItemsPositions.contains(position)

        when (strategy) {
            SelectedStrategy.ONE -> {
                val previousSelectedPositions = ArrayList(selectedItemsPositions)
                selectedItemsPositions.clear()

                previousSelectedPositions.forEach { previousPosition ->
                    notifyItemChanged(previousPosition)
                }

                if (!isSelected) {
                    selectedItemsPositions.add(position)
                    notifyItemChanged(position)
                }
            }
            SelectedStrategy.FEW -> {
                if (isSelected) {
                    selectedItemsPositions.remove(position)
                } else {
                    selectedItemsPositions.add(position)
                }
                notifyItemChanged(position)
            }
        }
    }

    private fun emitSelectedChanges() {
        val selectedItems = selectedItemsPositions.map { position -> items[position] }
        selectedItemsChanges.invoke(selectedItems)
    }
}