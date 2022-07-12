package ru.notasi.rosmosdev

import androidx.recyclerview.widget.RecyclerView
import ru.notasi.rosmosdev.databinding.ListItemBinding

class ListViewHolder(
    private val listItemBinding: ListItemBinding,
    private val clickListener: ItemClickListener,
) : RecyclerView.ViewHolder(listItemBinding.root) {

    fun bindItem(item: ItemModel) = with(listItemBinding) {
        title.text = item.title
        description.text = item.description
        itemView.setOnClickListener { clickListener.onClick(item = item) }
    }

}