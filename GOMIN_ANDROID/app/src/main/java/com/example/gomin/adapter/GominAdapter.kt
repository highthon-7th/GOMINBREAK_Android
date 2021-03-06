package com.example.gomin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.gomin.databinding.ItemPickGominBinding
import com.example.gomin.dto.GominList
import com.example.gomin.viewmodel.GominViewModel

class GominAdapter(private val vm: GominViewModel) :
    RecyclerView.Adapter<GominAdapter.GominViewHolder>() {

    private var gomintList = ArrayList<GominList>()

    inner class GominViewHolder(private val binding: ItemPickGominBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GominList, position: Int) {

            binding.vm = vm
            binding.notifyChange()
        }
    }

    fun setItem(list: List<GominList>) {
        this.gomintList = list as ArrayList<GominList>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GominViewHolder {
        val binding =
            ItemPickGominBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GominViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return gomintList.size
    }

    override fun onBindViewHolder(holder: GominViewHolder, position: Int) {
        holder.bind(gomintList[position], position)
    }

}