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
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityMapBangunanBinding
import com.b21cap0237.capstone.mapBangunan.model.Bangunan
import com.b21cap0237.capstone.mapBangunan.model.Kerusakan
import com.b21cap0237.capstone.mapBangunan.viewmodel.BangunanViewModel
import com.b21cap0237.capstone.response.DistrictDataItem
import com.b21cap0237.capstone.response.MapResponse
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
import kotlin.properties.Delegates


class MapBangunan : AppCompatActivity() {
    private lateinit var binding: ActivityMapBangunanBinding
    private lateinit var bangunanViewModel: BangunanViewModel

    companion object {
        const val EXTRA_BANGUNAN = "extra_bangunan"
    }

    private var idBangunan: Int = 0
    private var idAfter: Int = 0
    private var idBefore: Int = 0
    private var idTotal: Int = 0
    private lateinit var namaKelurahan: String
    private lateinit var gambarAfter:String
    private lateinit var gambarBefore:String
    private lateinit var circularProgressDrawable:CircularProgressDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_bangunan)
        binding = ActivityMapBangunanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bangunanViewModel= ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(BangunanViewModel::class.java)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        circularProgressDrawable = CircularProgressDrawable(this)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        val data=intent.getParcelableExtra<DistrictDataItem>(EXTRA_BANGUNAN) as DistrictDataItem
        idBangunan= data.mapId!!
        namaKelurahan=data.name.toString()
        idTotal=idBangunan*2
        idAfter=idTotal-1
        idBefore=idTotal
        supportActionBar?.title=namaKelurahan
        showImageBefore()
        showLegend()
        btnBencana()
    }
    private fun btnBencana(){
        binding.before.setOnClickListener {
            showImageBefore()
        }
        binding.after.setOnClickListener {
            showImageAfter()
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
    private fun showImageAfter() {
        showLoading(true)
        bangunanViewModel.setBangunanById(idAfter)
        bangunanViewModel.getBangunanById().observe(this,{data->
            val uri= Uri.parse(data[0].photo)
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
        })
    }
    private fun showImageBefore(){
        showLoading(true)
        bangunanViewModel.setBangunanById(idBefore)
        bangunanViewModel.getBangunanById().observe(this,{data->
            val uri= Uri.parse(data[0].photo)
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
