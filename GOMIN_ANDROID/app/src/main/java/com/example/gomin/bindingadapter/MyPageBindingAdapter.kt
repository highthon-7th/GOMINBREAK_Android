package com.example.gomin.bindingadapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("gominCount")
fun TextView.setCount(count: Int) {
    val countText = "$count 개"
    text = countText
}