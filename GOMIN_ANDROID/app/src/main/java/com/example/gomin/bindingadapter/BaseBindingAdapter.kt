package com.example.gomin.bindingadapter

import android.graphics.PorterDuff
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.gomin.R
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

@BindingAdapter("glide_image_load")
fun glideImageLoad(imageView: ImageView, resource: String?) {
    val circularProgressDrawable = CircularProgressDrawable(imageView.context).apply {
        strokeWidth = 10f
        centerRadius = 40f
        setColorFilter(ContextCompat.getColor(imageView.context, R.color.blue_700), PorterDuff.Mode.SRC_IN )
    }
    circularProgressDrawable.start()

    Glide.with(imageView.context)
        .load(resource)
        .placeholder(circularProgressDrawable)
        .error(R.drawable.profiledefault)
        .into(imageView)
}