package com.b21cap0237.capstone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.b21cap0237.capstone.akun.AkunFragment
import com.b21cap0237.capstone.databinding.ActivityMainBinding
import com.b21cap0237.capstone.home.HomeFragment
import com.b21cap0237.capstone.kondisiLapangan.fragment.KondisiLapFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        fragmentManager
            .beginTransaction()
            .add(R.id.container, homeFragment)
            .commit()
        binding.navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_lap -> {
                    loadFragment(KondisiLapFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_account-> {
                    loadFragment(AkunFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}