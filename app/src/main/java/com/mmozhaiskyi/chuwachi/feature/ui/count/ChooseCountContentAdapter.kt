package com.mmozhaiskyi.chuwachi.feature.ui.count

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChooseCountContentAdapter(
    private val items: List<ChooseCountContentModel>,
    private val clickListener: (ChooseCountContentModel) -> Unit
) : RecyclerView.Adapter<ChooseCountContentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseCountContentViewHolder {
        val type = ChooseCountContentModel.ViewType.values()[viewType]
        return when (type) {
            ChooseCountContentModel.ViewType.TITLE -> ChooseCountContentViewHolder.Title.inflate(parent)
            ChooseCountContentModel.ViewType.NUMBER -> ChooseCountContentViewHolder.Number.inflate(parent)
            ChooseCountContentModel.ViewType.MORE_BUTTON -> ChooseCountContentViewHolder.MoreButton.inflate(parent)
        }
    }

    override fun getItemViewType(position: Int) = items[position].type.ordinal

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ChooseCountContentViewHolder, position: Int) {
        val item = items[position]
        holder.apply {
            bind(item)

            itemView.setOnClickListener { clickListener(item) }
        }
    }
}
