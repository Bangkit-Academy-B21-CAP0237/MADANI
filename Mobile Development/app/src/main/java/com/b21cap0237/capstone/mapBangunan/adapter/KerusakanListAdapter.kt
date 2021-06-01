package com.b21cap0237.capstone.mapBangunan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b21cap0237.capstone.databinding.ItemNotifBinding
import com.b21cap0237.capstone.home.adapter.NotifListAdapter
import com.b21cap0237.capstone.home.model.Notif
import com.b21cap0237.capstone.mapBangunan.model.Kerusakan
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class KerusakanListAdapter(private val ListKerusakan: ArrayList<Kerusakan>): RecyclerView.Adapter<KerusakanListAdapter.ListViewHolder>() {
    private var onItemClickCallback: KerusakanListAdapter.OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: KerusakanListAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    inner class ListViewHolder(private val binding: ItemNotifBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(kerusakan: Kerusakan){
            with(binding){
                imgNotif?.let {
                    Glide.with(itemView.context)
                        .load(kerusakan.urlImg)
                        .apply(RequestOptions().override(155,155))
                        .into(it)
                }
                tvTitleNotif.text=kerusakan.title
                tvLocation.text=kerusakan.location
                itemView.setOnClickListener{
                    onItemClickCallback?.onItemClicked(kerusakan)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding=ItemNotifBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(ListKerusakan[position])
    }

    override fun getItemCount(): Int {
        return ListKerusakan.size
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Kerusakan)
    }
}