package com.b21cap0237.capstone.infodetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityInfoDetailBinding
import com.b21cap0237.capstone.databinding.ActivityLaporBinding

class InfoDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_detail)
        binding = ActivityInfoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title=getString(R.string.lapor)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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