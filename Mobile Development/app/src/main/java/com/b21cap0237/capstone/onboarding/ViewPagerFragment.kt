package com.b21cap0237.capstone.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentHalamanKeduaBinding
import com.b21cap0237.capstone.databinding.FragmentHomeBinding
import com.b21cap0237.capstone.databinding.FragmentViewPagerBinding
import com.b21cap0237.capstone.onboarding.halaman.HalamanKedua
import com.b21cap0237.capstone.onboarding.halaman.HalamanKetiga
import com.b21cap0237.capstone.onboarding.halaman.HalamanPertama


class ViewPagerFragment : Fragment() {
    private lateinit var binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        binding= FragmentViewPagerBinding.bind(view)
        val fragmentList = arrayListOf<Fragment>(
            HalamanPertama(),
            HalamanKedua(),
            HalamanKetiga()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter

        return view
    }

}