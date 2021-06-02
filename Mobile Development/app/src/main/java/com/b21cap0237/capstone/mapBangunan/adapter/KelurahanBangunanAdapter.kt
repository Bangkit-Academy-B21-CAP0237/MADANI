package com.b21cap0237.capstone.mapBangunan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b21cap0237.capstone.databinding.ItemBangunanBinding
import com.b21cap0237.capstone.databinding.ItemNotifBinding
import com.b21cap0237.capstone.mapBangunan.model.Bangunan
import com.b21cap0237.capstone.mapBangunan.model.Kerusakan
import com.b21cap0237.capstone.response.DistrictDataItem

class KelurahanBangunanAdapter(private val ListBangunan: List<DistrictDataItem>): RecyclerView.Adapter<KelurahanBangunanAdapter.ListViewHolder>() {
    private var onItemClickCallback: KelurahanBangunanAdapter.OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: KelurahanBangunanAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    inner class ListViewHolder(private val binding: ItemBangunanBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(districtDataItem: DistrictDataItem){
            with(binding){
                kelurahan.text=districtDataItem.name
                itemView.setOnClickListener{
                    onItemClickCallback?.onItemClicked(districtDataItem)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding=ItemBangunanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(ListBangunan[position])
    }

    override fun getItemCount(): Int {
        return ListBangunan.size
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: DistrictDataItem)
    }
}