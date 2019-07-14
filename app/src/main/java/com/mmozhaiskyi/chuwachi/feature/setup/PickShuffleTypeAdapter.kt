package com.mmozhaiskyi.chuwachi.feature.setup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.mmozhaiskyi.chuwachi.R
import com.mmozhaiskyi.chuwachi.feature.utils.SelectableRecyclerViewAdapter
import com.mmozhaiskyi.chuwachi.feature.utils.SelectableViewHolder
import com.mmozhaiskyi.chuwachi.feature.utils.SelectedStrategy
import com.mmozhaiskyi.chuwachi.feature.utils.SingleTypeViewHolderFactory
import kotlinx.android.synthetic.main.item_shuffle_type.view.*

class PickShuffleTypeAdapter(
    items: List<ShuffleTypeViewModel>,
    selectableChanges: (List<ShuffleTypeViewModel>) -> Unit
) : SelectableRecyclerViewAdapter<ShuffleTypeViewModel>(
    items = items,
    strategy = SelectedStrategy.ONE,
    viewHolderFactory = SingleTypeViewHolderFactory { parent -> ShuffleTypeHolder.inflate(parent) },
    selectedItemsChanges = selectableChanges,
    defaultSelectedPositions = listOf(0)
) {

    class ShuffleTypeHolder(private val view: View) : SelectableViewHolder<ShuffleTypeViewModel>(view) {

        override fun bind(item: ShuffleTypeViewModel, isSelected: Boolean): Unit = with(view) {
            title.setText(item.title)
            description.setText(item.description)

            val backgroundColor = ContextCompat.getColor(context, item.backgroundColor)
            container.setCardBackgroundColor(backgroundColor)

            checkLabel.isVisible = isSelected
        }

        companion object {

            fun inflate(parent: ViewGroup): ShuffleTypeHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shuffle_type, parent, false)
                return ShuffleTypeHolder(view)
            }
        }
    }
}
