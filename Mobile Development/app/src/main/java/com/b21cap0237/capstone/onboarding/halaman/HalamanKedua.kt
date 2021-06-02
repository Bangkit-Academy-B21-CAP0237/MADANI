package com.b21cap0237.capstone.onboarding.halaman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentHalamanKeduaBinding
import com.b21cap0237.capstone.databinding.FragmentLoginBinding
import com.b21cap0237.capstone.databinding.FragmentViewPagerBinding


class HalamanKedua : Fragment() {
    private lateinit var binding: FragmentHalamanKeduaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_halaman_kedua, container, false)
        binding= FragmentHalamanKeduaBinding.bind(view)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.next2.setOnClickListener {
            viewPager?.currentItem = 2
        }
        return view
    }
}