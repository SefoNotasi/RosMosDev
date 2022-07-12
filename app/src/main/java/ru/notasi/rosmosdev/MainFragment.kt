package ru.notasi.rosmosdev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ru.notasi.rosmosdev.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>(), ItemClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun inflateLayout(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ListAdapter(items = createItems(), clickListener = this@MainFragment)
        }
    }

    private fun createItems(): List<ItemModel> {

        val items = mutableListOf<ItemModel>()
        var id = 0

        repeat(times = 10) {
            id++
            items.add(
                ItemModel(
                    id = id,
                    title = "Item #$id",
                    description = "Description of item #$id"
                )
            )
        }

        return items
    }

    override fun onClick(item: ItemModel) =
        Toast.makeText(context, "Item #${item.id} clicked", Toast.LENGTH_SHORT).show()

}