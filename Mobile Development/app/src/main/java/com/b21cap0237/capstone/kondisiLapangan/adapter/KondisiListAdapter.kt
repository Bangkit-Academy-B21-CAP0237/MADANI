package com.b21cap0237.capstone.kondisiLapangan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ItemKondisiBinding
import com.b21cap0237.capstone.kondisiLapangan.model.Kondisi
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class KondisiListAdapter(private val ListKondisi: ArrayList<Kondisi>): RecyclerView.Adapter<KondisiListAdapter.ListViewHolder>() {
    private var onItemClickCallback: KondisiListAdapter.OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: KondisiListAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(private val binding: ItemKondisiBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(kondisi: Kondisi){
            val circularProgressDrawable = CircularProgressDrawable(itemView.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()
            with(binding){
                imgNotif?.let {
                    Glide.with(itemView.context)
                        .load(kondisi.kondisiGambar)
                        .apply( RequestOptions.placeholderOf(circularProgressDrawable)
                            .error(R.drawable.ic_error)).override(155,155)
                        .into(it)
                }
                tvTitle.text=kondisi.kondisiJudul
                tvLocation.text=kondisi.kondisiLokasi

                tvdate.text=kondisi.kondisiDate
                itemView.setOnClickListener{
                    onItemClickCallback?.onItemClicked(kondisi)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KondisiListAdapter.ListViewHolder {
        val binding=ItemKondisiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KondisiListAdapter.ListViewHolder, position: Int) {
        holder.bind(ListKondisi[position])
    }

    override fun getItemCount(): Int {
        return ListKondisi.size
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Kondisi)
    }
}