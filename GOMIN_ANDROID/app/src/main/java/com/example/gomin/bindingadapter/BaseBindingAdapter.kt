package com.example.gomin.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gomin.adapter.RecyclerViewAdapter
import com.example.gomin.adapter.RecyclerViewItem

@BindingAdapter("recyclerItems")
fun RecyclerView.setList(list: List<RecyclerViewItem>?) {
    if (adapter == null) {
        adapter = RecyclerViewAdapter()
        layoutManager = LinearLayoutManager(context)
    }

    if (list != null) {
        (adapter as? RecyclerViewAdapter)?.updateData(list)
    }
}