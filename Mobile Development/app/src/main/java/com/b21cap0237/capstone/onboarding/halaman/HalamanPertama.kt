package com.b21cap0237.capstone.onboarding.halaman

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentHalamanKetigaBinding
import com.b21cap0237.capstone.databinding.FragmentHalamanPertamaBinding
import com.b21cap0237.capstone.login.LoginActivity


class HalamanPertama : Fragment() {
    private lateinit var binding: FragmentHalamanPertamaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_halaman_pertama, container, false)
        binding= FragmentHalamanPertamaBinding.bind(view)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.next.setOnClickListener {
            viewPager?.currentItem = 1
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSkip.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
            activity?.finish()
        }
    }
}