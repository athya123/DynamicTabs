package com.tare.dummytabs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tare.dummytabs.R
import com.tare.dummytabs.databinding.ItemListRvBinding
import com.tare.dummytabs.pojo.entities.ProductItems

class TabItemsAdapter : RecyclerView.Adapter<TabItemsAdapter.ViewHolder>() {
    private var itemList: List<ProductItems> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemListRvBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_list_rv, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun update(updated: List<ProductItems>?) {
        val old = itemList
        itemList = updated ?: listOf()
        DiffUtil.calculateDiff(com.tare.dummytabs.utils.DiffUtil(old, itemList))
            .dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding: ItemListRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: ProductItems) {
            binding.item = currentItem
            binding.executePendingBindings()
        }
    }
}