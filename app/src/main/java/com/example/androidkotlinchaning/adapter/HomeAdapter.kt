package com.example.androidkotlinchaning.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidkotlinchaning.databinding.ItemHomeImageBinding
import com.example.androidkotlinchaning.databinding.ItemHomeNotImageBinding
import com.example.androidkotlinchaning.model.Home

class HomeAdapter(
    private var homes: MutableList<Home>
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
        val home = homes[position]
        if (home.imageContent != null) {
            (holder as HomeWithImageViewHolder).setData(homes[position])
        } else {
            (holder as HomeNotImageViewHolder).setData(homes[position])
        }
    }

    override fun getItemCount(): Int = homes.size

    override fun getItemViewType(position: Int): Int {
        if (homes[position].imageContent != null) {
            return TYPE_IMAGE
        }

        return TYPE_NOT_IMAGE
    }

    fun update (homes: MutableList<Home>) {
        this.homes = homes
        notifyDataSetChanged()
    }

    class HomeWithImageViewHolder(binding: ItemHomeImageBinding) : RecyclerView.ViewHolder(binding.root) {
        private val binding = binding
        fun setData (home: Home) {
            binding.imgAvatar.setImageResource(home.avatar)
            binding.txtName.text = home.name
            binding.txtTime.text = home.time
            binding.txtContent.text = home.content
            binding.txtMoney.text = home.money
            home.imageContent?.let { binding.imgContent.setImageResource(it) }
        }
    }

    class HomeNotImageViewHolder(binding: ItemHomeNotImageBinding) : RecyclerView.ViewHolder(binding.root) {
        private val binding = binding
        fun setData (home: Home) {
            binding.imgAvatar.setImageResource(home.avatar)
            binding.txtName.text = home.name
            binding.txtTime.text = home.time
            binding.txtContent.text = home.content
            binding.txtMoney.text = home.money
        }
    }
}