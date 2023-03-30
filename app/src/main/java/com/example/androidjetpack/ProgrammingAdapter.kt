package com.example.androidjetpack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ProgrammingAdapter : ListAdapter<ProgrammingItem, ProgrammingAdapter.ProgrammingVH>(DiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ProgrammingVH(view)
    }

    override fun onBindViewHolder(holder: ProgrammingVH, position: Int) {
        holder.bind(getItem(position))
    }


    class ProgrammingVH(itemView: View) : ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tvName)
        val initial = itemView.findViewById<TextView>(R.id.tvInitial)

        fun bind(p: ProgrammingItem) {
            name.text = p.name
            initial.text = p.initial
        }
    }

    class DiffUtils : DiffUtil.ItemCallback<ProgrammingItem>() {
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem == newItem
        }

    }
}