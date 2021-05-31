package com.b21cap0237.capstone.mapJalur

import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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
            .into(object : SimpleTarget<File?>() {
                override fun onLoadFailed(@Nullable errorDrawable: Drawable?) {
                    super.onLoadFailed(errorDrawable)
                    Log.d("load failed", "nothing")
                }
                override fun onResourceReady(resource: File, transition: Transition<in File?>?) {
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

}