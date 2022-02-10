package com.tare.dummytabs.utils

import androidx.recyclerview.widget.DiffUtil
import com.tare.dummytabs.pojo.entities.ProductItems

class DiffUtil(private val oldList: List<ProductItems>, private val newList: List<ProductItems>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }
}