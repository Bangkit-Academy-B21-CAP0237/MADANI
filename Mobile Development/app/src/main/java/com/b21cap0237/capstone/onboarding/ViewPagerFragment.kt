package com.b21cap0237.capstone.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentViewPagerBinding
import com.b21cap0237.capstone.onboarding.halaman.HalamanKedua
import com.b21cap0237.capstone.onboarding.halaman.HalamanKetiga
import com.b21cap0237.capstone.onboarding.halaman.HalamanPertama
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

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

        view.viewPager.adapter = adapter

        return view
    }

}