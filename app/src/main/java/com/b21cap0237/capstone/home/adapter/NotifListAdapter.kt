package com.b21cap0237.capstone.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b21cap0237.capstone.databinding.ItemMenuBinding
import com.b21cap0237.capstone.databinding.ItemNotifBinding
import com.b21cap0237.capstone.home.model.ListMenu
import com.b21cap0237.capstone.home.model.Notif
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.sql.Date
import java.sql.Timestamp

class NotifListAdapter(private val ListNotif: ArrayList<Notif>): RecyclerView.Adapter<NotifListAdapter.ListViewHolder>() {
    private var onItemClickCallback: NotifListAdapter.OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: NotifListAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    inner class ListViewHolder(private val binding: ItemNotifBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(notif: Notif){
            with(binding){
                imgNotif?.let {
                    Glide.with(itemView.context)
                        .load(notif.imgUrl)
                        .apply(RequestOptions().override(155,155))
                        .into(it)
                }
                tvTitleNotif.text=notif.title
                tvLocation.text=notif.locationNotif

                tvdate.text=notif.dateNotif
            itemView.setOnClickListener{
                onItemClickCallback?.onItemClicked(notif)
            }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding=ItemNotifBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(ListNotif[position])
    }

    override fun getItemCount(): Int {
        return ListNotif.size
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Notif)
    }
}