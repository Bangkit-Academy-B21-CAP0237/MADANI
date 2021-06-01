package com.b21cap0237.capstone.kondisiLapangan

import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityKondisiDetailBinding
import com.b21cap0237.capstone.home.model.Notif
import com.b21cap0237.capstone.kondisiLapangan.model.Kondisi
import com.b21cap0237.capstone.notif.NotifDetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

class KondisiDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKondisiDetailBinding
    companion object {
        const val EXTRA_KONDISI = "extra_kondisi"
    }
    private lateinit var kondisiId:String
    private lateinit var kondisiJudul:String
    private lateinit var kondisiLokasi:String
    private lateinit var kondisiKonten:String
    private lateinit var kondisiDate:String
    private lateinit var kondisiGambar:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKondisiDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data=intent.getParcelableExtra<Kondisi>(EXTRA_KONDISI) as Kondisi

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        kondisiId=data.kondisiJudul
        kondisiDate=data.kondisiDate
        kondisiGambar=data.kondisiGambar
        kondisiJudul=data.kondisiJudul
        kondisiKonten=data.kondisiKonten
        kondisiLokasi=data.kondisiLokasi

        val uri= Uri.parse(kondisiGambar)

        binding.toolbarLayout.title = kondisiJudul

        val konten: TextView =findViewById(R.id.contentNotif)
        konten.text=kondisiKonten
        val date: TextView =findViewById(R.id.date)
        date.text=data.kondisiDate
        val location: TextView =findViewById(R.id.location)
        location.text=data.kondisiLokasi


        Glide.with(this)
            .load(uri)
            .into(object : CustomTarget<Drawable?>() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

                override fun onLoadCleared(placeholder: Drawable?) {}
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable?>?
                ) {
                    binding.appBar.background = resource
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            16908332->{
                this.finish()
                true
            }
            else -> true
        }
    }
}