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
    defaultSelectedItem: ShuffleTypeViewModel,
    selectableChanges: (List<ShuffleTypeViewModel>) -> Unit
) : SelectableRecyclerViewAdapter<ShuffleTypeViewModel>(
    items = items,
    strategy = SelectedStrategy.ONE,
    viewHolderFactory = SingleTypeViewHolderFactory { parent -> ShuffleTypeHolder.inflate(parent) },
    selectedItemsChanges = selectableChanges,
    defaultSelectedPositions = listOf(items.indexOf(defaultSelectedItem))
) {

    class ShuffleTypeHolder(private val view: View) : SelectableViewHolder<ShuffleTypeViewModel>(view) {

        override fun bind(item: ShuffleTypeViewModel, isSelected: Boolean): Unit = with(view) {
            title.setText(item.title)
            description.setText(item.description)

            val (backgroundColorRes, textColorRes) = if (isSelected) {
                R.color.colorPrimary to R.color.white
            } else {
                R.color.greyLight to R.color.textColorSecondary
            }

            val backgroundColor = ContextCompat.getColor(context, backgroundColorRes)
            val textColor = ContextCompat.getColor(context, textColorRes)

            container.setCardBackgroundColor(backgroundColor)
            title.setTextColor(textColor)
            description.setTextColor(textColor)
        }

        companion object {

            fun inflate(parent: ViewGroup): ShuffleTypeHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shuffle_type, parent, false)
                return ShuffleTypeHolder(view)
            }
        }
    }
}
