package com.b21cap0237.capstone.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivitySignUpBinding
import com.b21cap0237.capstone.signup.fragment.FormSignUpFragment

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
        val fragmentManager = supportFragmentManager
        val formSignUpFragment = FormSignUpFragment()
        fragmentManager
            .beginTransaction()
            .add(R.id.container, formSignUpFragment)
            .commit()
    }
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}