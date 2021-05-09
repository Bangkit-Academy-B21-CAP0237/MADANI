package com.b21cap0237.capstone.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.b21cap0237.capstone.MainActivity
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityLoginBinding
import com.b21cap0237.capstone.databinding.ActivityMainBinding
import com.b21cap0237.capstone.signup.SignUpActivity

class LoginActivity : Activity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.btnNewAccount.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}