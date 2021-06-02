package com.b21cap0237.capstone.mapBangunan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityListBangunanBinding
import com.b21cap0237.capstone.databinding.ActivityMapBangunanBinding
import com.b21cap0237.capstone.mapBangunan.MapBangunan.Companion.EXTRA_BANGUNAN
import com.b21cap0237.capstone.mapBangunan.adapter.KelurahanBangunanAdapter
import com.b21cap0237.capstone.mapBangunan.model.Bangunan
import com.b21cap0237.capstone.mapBangunan.viewmodel.BangunanViewModel
import com.b21cap0237.capstone.response.DistrictDataItem
import com.bumptech.glide.Glide

class ListBangunanActivity : AppCompatActivity() {
    private lateinit var bangunanViewModel: BangunanViewModel
    private lateinit var binding: ActivityListBangunanBinding
    private  lateinit var kelurahanBangunanAdapter: KelurahanBangunanAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_bangunan)
        binding = ActivityListBangunanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title=getString(R.string.daftar_kelurahan)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bangunanViewModel= ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(BangunanViewModel::class.java)
        bangunanViewModel.setDistrict()
        listKelurahan()
    }
    fun listKelurahan(){
        binding.rvBangunan.setHasFixedSize(true)
        binding.rvBangunan.layoutManager=LinearLayoutManager(this)

        bangunanViewModel.getDistrict().observe(this,{items->
            showLoading(false)
            kelurahanBangunanAdapter=KelurahanBangunanAdapter(items)
            binding.rvBangunan.adapter=kelurahanBangunanAdapter

            kelurahanBangunanAdapter.setOnItemClickCallback(object :KelurahanBangunanAdapter.OnItemClickCallback{
                override fun onItemClicked(data: DistrictDataItem) {
                    Toast.makeText(this@ListBangunanActivity, data.name, Toast.LENGTH_SHORT).show()
                    val intent= Intent(this@ListBangunanActivity, MapBangunan::class.java)
                    intent.putExtra(EXTRA_BANGUNAN,data)
                    startActivity(intent)
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