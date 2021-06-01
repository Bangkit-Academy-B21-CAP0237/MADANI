package com.b21cap0237.capstone.infodetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityInfoDetailBinding
import com.b21cap0237.capstone.databinding.ActivityLaporBinding
import com.b21cap0237.capstone.infodetail.viewmodel.InfoViewModel
import com.b21cap0237.capstone.mapJalur.viewmodel.JalurViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class InfoDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoDetailBinding
    private lateinit var infoViewModel: InfoViewModel
    private lateinit var circularProgressDrawable : CircularProgressDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_detail)
        binding = ActivityInfoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title=getString(R.string.info_aplikasi)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        infoViewModel= ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            InfoViewModel::class.java)
        showData()
        circularProgressDrawable = CircularProgressDrawable(this)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
    }
    private fun showData(){
        infoViewModel.setInfoDetail()
        infoViewModel.getKondisi().observe(this,{data->
            binding.judul.text=data[0].judulAplikasi
            binding.konten.text=data[0].tentangAplikasi
            Glide.with(this)
                .load(data[0].gambarAplikasi)
                .apply( RequestOptions.placeholderOf(circularProgressDrawable)
                    .error(R.drawable.ic_error)).override(155,155)
                .into(binding.logo)
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