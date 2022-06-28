package com.geektech.lesson73kotlin2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.lesson73kotlin2.databinding.ItemAnimalsBinding

class AnimalAdapter : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {
    var animal = arrayListOf<String>()
    var onLongClick: ((Int) -> Unit)? = null

    inner class AnimalViewHolder(private var binding: ItemAnimalsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(animal: String) {
            binding.tvName.text = animal
            itemView.setOnLongClickListener {
                onLongClick?.invoke(adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(
            ItemAnimalsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.onBind(animal[position])
    }

    override fun getItemCount() = animal.size

    @SuppressLint("NotifyDataSetChanged")
    fun addAnimal(str: String) {
        str.let {
            animal.add(0, it)
            notifyItemInserted(animal.indexOf(str))
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun remove(position: Int) {
        animal.removeAt(position)
        notifyItemRemoved(position)
    }
}

