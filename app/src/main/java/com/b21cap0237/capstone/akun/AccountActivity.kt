package com.b21cap0237.capstone.akun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityAccountBinding
import com.b21cap0237.capstone.databinding.ActivityLoginBinding
import com.b21cap0237.capstone.login.LoginFragment

class AccountActivity : AppCompatActivity() {

    private lateinit var accountBinding: ActivityAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        accountBinding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(accountBinding.root)
        val fragmentManager = supportFragmentManager
        val akunFragment = AkunFragment()
        fragmentManager
            .beginTransaction()
            .add(R.id.container, akunFragment)
            .commit()
    }
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}