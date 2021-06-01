package com.b21cap0237.capstone.onboarding.halaman

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_halaman_pertama.view.*

class HalamanPertama : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_halaman_pertama, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        view.next.setOnClickListener {
            viewPager?.currentItem = 1
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.btn_skip.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
            activity?.finish()
        }
    }
}