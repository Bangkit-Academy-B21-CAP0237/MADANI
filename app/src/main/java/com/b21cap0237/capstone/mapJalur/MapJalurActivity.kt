package com.b21cap0237.capstone.mapJalur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityMainBinding
import com.b21cap0237.capstone.databinding.ActivityMapBangunanBinding
import com.b21cap0237.capstone.databinding.ActivityMapJalurBinding
import com.b21cap0237.capstone.mapBangunan.adapter.KerusakanListAdapter
import com.b21cap0237.capstone.mapBangunan.model.Kerusakan
import com.bumptech.glide.Glide

class MapJalurActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapJalurBinding
    private lateinit var kerusakanListAdapter: KerusakanListAdapter
    private lateinit var datatitle:Array<String>
    private lateinit var dataimgUrl:Array<String>
    private lateinit var datadate:Array<String>
    private lateinit var datalocation:Array<String>
    private lateinit var dataContent:Array<String>
    private var list: ArrayList<Kerusakan> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_jalur)
        binding = ActivityMapJalurBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title=getString(R.string.jalur_cepat)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.rvJalurDilalui.setHasFixedSize(true)

        binding.rvJalurDilalui.layoutManager = LinearLayoutManager(this)
        kerusakanListAdapter = KerusakanListAdapter(list)
        list.addAll(getListKerusakan())
        binding.rvJalurDilalui.adapter = kerusakanListAdapter
        val url="https://www.orfeo-toolbox.org/CookBook/_images/QB_1_ortho_MV_C123456_CM.png"
        Glide.with(this)
            .load(url)
            .into(binding.imgMap)
        true
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.menu_map,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.map_utara -> {
                val url="https://storage.googleapis.com/road_resunet/mask_output_pre_disaster.png"
                Glide.with(this)
                    .load(url)
                    .into(binding.imgMap)
                true
            }
            R.id.map_selatan -> {
                val url="https://www.rossedwards.co.uk/arma/QGIS/classify_linear.PNG"
                Glide.with(this)
                    .load(url)
                    .into(binding.imgMap)
                true
            }
            R.id.map_barat -> {
                val url="https://www.orfeo-toolbox.org/CookBook/_images/sample-selection.png"
                Glide.with(this)
                    .load(url)
                    .into(binding.imgMap)
                true
            }
            R.id.map_timur -> {
                val url="https://www.orfeo-toolbox.org/CookBook/_images/QB_1_ortho_MV_C123456_CM.png"
                Glide.with(this)
                    .load(url)
                    .into(binding.imgMap)
                true
            }
            16908332->{
                this.finish()
                true
            }
            else -> true
        }
    }
    private fun getListKerusakan(): ArrayList<Kerusakan> {
        val listData= ArrayList<Kerusakan>()
        datatitle = resources.getStringArray(R.array.title_notif)
        dataimgUrl = resources.getStringArray(R.array.URL_notif)
        datalocation = resources.getStringArray(R.array.location_notif)
        dataContent=resources.getStringArray(R.array.content)
        for(position in datatitle.indices){
            val kerusakan= Kerusakan(
                datatitle[position],
                dataimgUrl[position],
                dataContent[position],
                datalocation[position]
            )
            listData.add(kerusakan)
        }
        return listData
    }
}