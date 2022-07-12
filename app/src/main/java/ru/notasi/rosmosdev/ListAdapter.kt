package ru.notasi.rosmosdev

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.notasi.rosmosdev.databinding.ListItemBinding

class ListAdapter(
    private val items: List<ItemModel>,
    private val clickListener: ItemClickListener
) : RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ListViewHolder(listItemBinding = binding, clickListener = clickListener)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        holder.bindItem(item = items[position])

    override fun getItemCount() = items.size

}