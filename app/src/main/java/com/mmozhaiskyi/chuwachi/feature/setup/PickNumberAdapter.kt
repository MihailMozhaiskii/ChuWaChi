package com.mmozhaiskyi.chuwachi.feature.setup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.mmozhaiskyi.chuwachi.R
import com.mmozhaiskyi.chuwachi.feature.utils.*
import kotlinx.android.synthetic.main.item_number.view.*

class PickNumberAdapter(
    range: IntRange,
    defaultSelectedItem: Int,
    selectableChanges: (List<Int>) -> Unit
) : SelectableRecyclerViewAdapter<Int>(
    items = range.toList(),
    strategy = SelectedStrategy.ONE,
    viewHolderFactory = SingleTypeViewHolderFactory { parent -> NumberHolder.inflate(parent) },
    selectedItemsChanges = selectableChanges,
    defaultSelectedPositions = listOf(range.indexOf(defaultSelectedItem))
) {

    class NumberHolder(private val view: View) : SelectableViewHolder<Int>(view) {

        override fun bind(item: Int, isSelected: Boolean): Unit = with(view) {
            number.text = item.toString()

            val backgroundColorRes = if (isSelected) R.color.colorPrimary else R.color.greyLight
            val textColorRes = if (isSelected) R.color.white else R.color.textColorSecondary

            val backgroundColor = ContextCompat.getColor(context, backgroundColorRes)
            numberContainer.setCardBackgroundColor(backgroundColor)

            val textColor = ContextCompat.getColor(context, textColorRes)
            number.setTextColor(textColor)
        }

        companion object {

            fun inflate(parent: ViewGroup): NumberHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_number, parent, false)
                return NumberHolder(view)
            }
        }
    }
}