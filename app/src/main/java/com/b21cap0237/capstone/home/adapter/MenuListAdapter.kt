package com.b21cap0237.capstone.home.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ItemMenuBinding
import com.b21cap0237.capstone.home.model.ListMenu
import com.bumptech.glide.Glide

class MenuListAdapter(private val ListMenu: ArrayList<ListMenu>): RecyclerView.Adapter<MenuListAdapter.ListViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    inner class ListViewHolder(private val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ListMenu: ListMenu){
            with(binding){
                Glide.with(itemView.context)
                    .load(ListMenu.ic)
                    .into(btnMenu)
                tvMenu.text=ListMenu.title
                Log.d("bind", ListMenu.title)
                itemView.setOnClickListener{
                    onItemClickCallback?.onItemClicked(ListMenu)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding=ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(ListMenu[position])
    }

    override fun getItemCount(): Int {
        return 4
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: ListMenu)
    }
}