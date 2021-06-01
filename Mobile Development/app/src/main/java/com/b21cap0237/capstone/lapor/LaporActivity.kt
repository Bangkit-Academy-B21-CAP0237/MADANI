package com.b21cap0237.capstone.lapor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityLaporBinding
import com.b21cap0237.capstone.databinding.ActivityMapJalurBinding

class LaporActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLaporBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lapor)
        binding = ActivityLaporBinding.inflate(layoutInflater)
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