package com.b21cap0237.capstone.mapJalur

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
import com.b21cap0237.capstone.databinding.ActivityListJalurBinding
import com.b21cap0237.capstone.mapBangunan.MapBangunan
import com.b21cap0237.capstone.mapBangunan.adapter.KelurahanBangunanAdapter
import com.b21cap0237.capstone.mapBangunan.model.Bangunan
import com.b21cap0237.capstone.mapBangunan.viewmodel.BangunanViewModel
import com.b21cap0237.capstone.mapJalur.MapJalurActivity.Companion.EXTRA_JALUR
import com.b21cap0237.capstone.mapJalur.adapter.KelurahanJalurAdapter
import com.b21cap0237.capstone.mapJalur.model.Jalur
import com.b21cap0237.capstone.mapJalur.viewmodel.JalurViewModel

class ListJalurActivity : AppCompatActivity() {
    private lateinit var jalurViewModel: JalurViewModel
    private lateinit var binding: ActivityListJalurBinding
    private  lateinit var kelurahanJalurAdapter: KelurahanJalurAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_jalur)
        binding = ActivityListJalurBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title=getString(R.string.daftar_kelurahan)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        jalurViewModel= ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(JalurViewModel::class.java)
        jalurViewModel.setJalur()
        listKelurahan()
    }

    private fun listKelurahan() {
        binding.rvjalur.setHasFixedSize(true)
        binding.rvjalur.layoutManager= LinearLayoutManager(this)

        jalurViewModel.getJalur().observe(this,{items->
            showLoading(false)
            kelurahanJalurAdapter=KelurahanJalurAdapter(items)
            binding.rvjalur.adapter=kelurahanJalurAdapter
            kelurahanJalurAdapter.setOnItemClickCallback(object :KelurahanJalurAdapter.OnItemClickCallback{

                override fun onItemClicked(data: Jalur) {
                    Toast.makeText(this@ListJalurActivity, data.namaKelurahan, Toast.LENGTH_SHORT).show()
                    val intent= Intent(this@ListJalurActivity, MapJalurActivity::class.java)
                    intent.putExtra(EXTRA_JALUR,data)
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