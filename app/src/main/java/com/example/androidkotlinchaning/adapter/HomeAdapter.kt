package com.example.androidkotlinchaning.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidkotlinchaning.databinding.ItemHomeImageBinding
import com.example.androidkotlinchaning.databinding.ItemHomeNotImageBinding
import com.example.androidkotlinchaning.model.Home

class HomeAdapter(
    private val homes: MutableList<Home>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_IMAGE = 1
    private val TYPE_NOT_IMAGE = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_IMAGE) {
            val itemBinding =
                ItemHomeImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return HomeWithImageViewHolder(itemBinding)
        }

        val itemBinding =
            ItemHomeNotImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeNotImageViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = homes.size

    override fun getItemViewType(position: Int): Int {
        if (homes[position].type == TYPE_IMAGE) {
            return TYPE_IMAGE
        }

        return TYPE_NOT_IMAGE
    }

    class HomeWithImageViewHolder(itemView: ItemHomeImageBinding) : RecyclerView.ViewHolder(itemView.root) {

    }
    class HomeNotImageViewHolder(itemView: ItemHomeNotImageBinding) : RecyclerView.ViewHolder(itemView.root) {

    }
}