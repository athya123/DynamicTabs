package com.tare.dummytabs.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tare.dummytabs.adapter.TabItemsAdapter
import com.tare.dummytabs.pojo.entities.ProductItems

@BindingAdapter("setImage")
fun bindImage(imageView: ImageView, url: String?) {
    url?.let {
        Picasso.get().load(it).into(imageView)
    }
}

@BindingAdapter("setTabItems")
fun bindItems(recyclerView: RecyclerView, list: List<ProductItems>?) {
    val adapter = getOrSetTabAdapter(recyclerView)
    adapter.update(list)
}

private fun getOrSetTabAdapter(recyclerView: RecyclerView): TabItemsAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is TabItemsAdapter) {
        recyclerView.adapter as TabItemsAdapter
    } else {
        val adapter = TabItemsAdapter()
        recyclerView.adapter = adapter
        adapter
    }
}

