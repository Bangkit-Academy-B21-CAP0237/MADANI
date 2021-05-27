package com.b21cap0237.capstone.onboarding.halaman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.b21cap0237.capstone.R
import kotlinx.android.synthetic.main.fragment_halaman_kedua.view.*


class HalamanKedua : Fragment() {
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_halaman_kedua, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        view.next2.setOnClickListener {
            viewPager?.currentItem = 2
        }
        return view
    }
}