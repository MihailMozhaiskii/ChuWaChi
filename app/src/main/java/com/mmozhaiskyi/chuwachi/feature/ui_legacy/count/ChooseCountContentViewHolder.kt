package com.mmozhaiskyi.chuwachi.feature.ui_legacy.count

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.mmozhaiskyi.chuwachi.R
import kotlinx.android.synthetic.main.item_count_number.view.*

sealed class ChooseCountContentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: ChooseCountContentModel)

    class Title private constructor(view: View) : ChooseCountContentViewHolder(view) {

        override fun bind(item: ChooseCountContentModel) = Unit

        companion object {

            fun inflate(parent: ViewGroup): Title {
                val view = inflateView(R.layout.item_title, parent)
                return Title(view)
            }
        }
    }

    class Number private constructor(private val view: View) : ChooseCountContentViewHolder(view) {

        override fun bind(item: ChooseCountContentModel) {
            item as ChooseCountContentModel.Number
            view.number.text = item.count.toString()
        }

        companion object {

            fun inflate(parent: ViewGroup): Number {
                val view = inflateView(R.layout.item_count_number, parent)
                return Number(view)
            }
        }
    }

    class MoreButton private constructor(view: View) : ChooseCountContentViewHolder(view) {

        override fun bind(item: ChooseCountContentModel) = Unit

        companion object {

            fun inflate(parent: ViewGroup): MoreButton {
                val view = inflateView(R.layout.item_count_more, parent)
                return MoreButton(view)
            }
        }
    }

    companion object {

        private fun inflateView(@LayoutRes res: Int, parent: ViewGroup) = LayoutInflater
            .from(parent.context)
            .inflate(res, parent, false)
    }
}
