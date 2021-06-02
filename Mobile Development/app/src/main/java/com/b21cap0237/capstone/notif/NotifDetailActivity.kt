package com.b21cap0237.capstone.notif

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
import com.b21cap0237.capstone.databinding.ActivityNotifDetailBinding
import com.b21cap0237.capstone.databinding.ContentScrollingBinding
import com.b21cap0237.capstone.home.model.Notif
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition


class NotifDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NOTIF = "extra_notif"
    }
    private lateinit var binding: ActivityNotifDetailBinding
    private lateinit var binding1: ContentScrollingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotifDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data=intent.getParcelableExtra<Notif>(EXTRA_NOTIF) as Notif
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbarLayout.title = data.title
        val uri= Uri.parse(data.imgUrl)

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
        val konten:TextView=findViewById(R.id.contentNotif)
        konten.text=data.kontent
        val date:TextView=findViewById(R.id.date)
        date.text=data.dateNotif
        val location:TextView=findViewById(R.id.location)
        location.text=data.locationNotif
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