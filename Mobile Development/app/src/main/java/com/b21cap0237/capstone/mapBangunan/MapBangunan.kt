package com.b21cap0237.capstone.mapBangunan

import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle

import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityMapBangunanBinding
import com.b21cap0237.capstone.mapBangunan.model.Bangunan
import com.b21cap0237.capstone.mapBangunan.model.Kerusakan
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.SCALE_TYPE_CUSTOM
import java.io.File
import java.net.URL


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
        showLegend()
        btnBencana()
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
            .load("https://firebasestorage.googleapis.com/v0/b/capstone-ba4d7.appspot.com/o/legend_hijau.png?alt=media&token=61884031-10eb-4203-9e7f-6a909b0531eb")
            .apply(RequestOptions().override(155,155))
            .into(binding.hijau)
        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/capstone-ba4d7.appspot.com/o/legend_merah.png?alt=media&token=8048be28-5276-4983-9ea9-d9325b8d5eeb")
            .apply(RequestOptions().override(155,155))
            .into(binding.merah)
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
                    binding.imgMap.setMinimumScaleType(SCALE_TYPE_CENTER_CROP)
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
    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}

private fun <TranscodeType> RequestBuilder<TranscodeType>.into(imageView: SubsamplingScaleImageView) {

}
