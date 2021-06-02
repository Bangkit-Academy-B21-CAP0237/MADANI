package com.b21cap0237.capstone.mapJalur.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b21cap0237.capstone.databinding.ItemBangunanBinding
import com.b21cap0237.capstone.mapBangunan.adapter.KelurahanBangunanAdapter
import com.b21cap0237.capstone.mapBangunan.model.Bangunan
import com.b21cap0237.capstone.mapJalur.model.Jalur
import com.b21cap0237.capstone.response.DistrictDataItem

class KelurahanJalurAdapter(private val ListJalur: List<DistrictDataItem>): RecyclerView.Adapter<KelurahanJalurAdapter.ListViewHolder>() {
    private var onItemClickCallback: KelurahanJalurAdapter.OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: KelurahanJalurAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    inner class ListViewHolder(private val binding: ItemBangunanBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(jalur: DistrictDataItem){
            with(binding){
                kelurahan.text=jalur.name
                itemView.setOnClickListener{
                    onItemClickCallback?.onItemClicked(jalur)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KelurahanJalurAdapter.ListViewHolder {
        val binding=ItemBangunanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KelurahanJalurAdapter.ListViewHolder, position: Int) {
        holder.bind(ListJalur[position])
    }

    override fun getItemCount(): Int {
        return ListJalur.size
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: DistrictDataItem)
    }
}