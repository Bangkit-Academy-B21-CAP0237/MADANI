package com.b21cap0237.capstone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        supportActionBar?.hide()
    }
}