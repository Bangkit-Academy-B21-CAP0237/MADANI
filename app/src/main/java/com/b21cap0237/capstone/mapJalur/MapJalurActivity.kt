package com.b21cap0237.capstone.mapJalur

import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityMainBinding
import com.b21cap0237.capstone.databinding.ActivityMapBangunanBinding
import com.b21cap0237.capstone.databinding.ActivityMapJalurBinding
import com.b21cap0237.capstone.mapBangunan.MapBangunan
import com.b21cap0237.capstone.mapBangunan.adapter.KerusakanListAdapter
import com.b21cap0237.capstone.mapBangunan.model.Bangunan
import com.b21cap0237.capstone.mapBangunan.model.Kerusakan
import com.b21cap0237.capstone.mapJalur.model.Jalur
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import java.io.File

class MapJalurActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_JALUR = "extra_jalur"

    }
    private lateinit var binding: ActivityMapJalurBinding
    private lateinit var idJalur: String
    private lateinit var namaKelurahan:String
    private lateinit var gambarAfter:String
    private lateinit var gambarBefore:String
    private lateinit var circularProgressDrawable: CircularProgressDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_jalur)
        binding = ActivityMapJalurBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        circularProgressDrawable = CircularProgressDrawable(this)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        val data=intent.getParcelableExtra<Jalur>(EXTRA_JALUR) as Jalur
        idJalur=data.idJalur
        namaKelurahan=data.namaKelurahan
        gambarAfter=data.gambarAfter
        gambarBefore=data.gambarBefore
        supportActionBar?.title=namaKelurahan
        showImage(gambarBefore)
        btnBencana()
        showLegend()
    }

    private fun btnBencana(){
        binding.before.setOnClickListener {
            showImage(gambarBefore)
        }
        binding.after.setOnClickListener {
            showImage(gambarAfter)
        }
    }
    private fun showLegend(){
        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/capstone-ba4d7.appspot.com/o/legend_putih.png?alt=media&token=7c609957-5b74-4fb7-ad0a-07dcc092acae")
            .apply(RequestOptions().override(155,155))
            .into(binding.white)
        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/capstone-ba4d7.appspot.com/o/legend_putih-1.png?alt=media&token=ef6eac6c-ce5b-479a-a17d-473a8ed5ea9b")
            .apply(RequestOptions().override(155,155))
            .into(binding.black)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.menu_utama,menu)
        return super.onCreateOptionsMenu(menu)
    }
    private fun showImage(url:String){
        val uri= Uri.parse(url)
        Glide.with(this)
            .download(uri)
            .apply(
                RequestOptions.placeholderOf(circularProgressDrawable)
                    .error(R.drawable.ic_error))
            .into(object : SimpleTarget<File?>() {
                override fun onLoadFailed(@Nullable errorDrawable: Drawable?) {
                    super.onLoadFailed(errorDrawable)
                    Log.d("load failed", "nothing")
                }
                override fun onResourceReady(resource: File, transition: Transition<in File?>?) {
                    showLoading(false)
                    binding.imgMap.setImage(ImageSource.uri(resource.absolutePath))
                    binding.imgMap.maxScale = 10f;
                    binding.imgMap.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP)
                }
            })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.before -> {
                showImage(gambarBefore)
                true
            }
            R.id.after -> {
                showImage(gambarAfter)
                true
            }

            16908332->{
                this.finish()
                true
            }
            else -> true
        }
    }
    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}