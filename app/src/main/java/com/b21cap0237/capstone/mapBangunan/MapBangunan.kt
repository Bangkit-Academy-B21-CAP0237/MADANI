package com.b21cap0237.capstone.mapBangunan

import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle

import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityMapBangunanBinding
import com.b21cap0237.capstone.mapBangunan.model.Bangunan
import com.b21cap0237.capstone.mapBangunan.model.Kerusakan
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.SCALE_TYPE_CUSTOM
import java.io.File


class MapBangunan : AppCompatActivity() {
    private lateinit var binding: ActivityMapBangunanBinding
    private var list: ArrayList<Kerusakan> = arrayListOf()

    companion object {
        const val EXTRA_BANGUNAN = "extra_bangunan"

    }

    private lateinit var idBangunan: String
    private lateinit var namaKelurahan:String
    private lateinit var gambarAfter:String
    private lateinit var gambarBefore:String
    private lateinit var circularProgressDrawable:CircularProgressDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_bangunan)
        binding = ActivityMapBangunanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        circularProgressDrawable = CircularProgressDrawable(this)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        val data=intent.getParcelableExtra<Bangunan>(EXTRA_BANGUNAN) as Bangunan
        idBangunan=data.idBangunan
        namaKelurahan=data.namaKelurahan
        gambarAfter=data.gambarAfter
        gambarBefore=data.gambarBefore
        supportActionBar?.title=namaKelurahan
        showImage(gambarBefore)
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
                    binding.imgMap.setMinimumScaleType(SCALE_TYPE_CENTER_CROP)
                }
            })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.menu_utama,menu)
        return super.onCreateOptionsMenu(menu)
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

private fun <TranscodeType> RequestBuilder<TranscodeType>.into(imageView: SubsamplingScaleImageView) {

}
