package com.b21cap0237.capstone.splashscreen

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentHomeBinding
import com.b21cap0237.capstone.databinding.FragmentSplashBinding
import com.b21cap0237.capstone.home.viewmodel.HomeViewModel
import com.b21cap0237.capstone.infodetail.viewmodel.InfoViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class SplashFragment : Fragment() {
    private lateinit var infoViewModel: InfoViewModel
    private lateinit var binding: FragmentSplashBinding
    private lateinit var circularProgressDrawable : CircularProgressDrawable
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSplashBinding.bind(view)
        circularProgressDrawable = context?.let { CircularProgressDrawable(it) }!!
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        infoViewModel= ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            InfoViewModel::class.java)
        infoViewModel.setSplash()
        infoViewModel.getSplash().observe(viewLifecycleOwner,{data->
            Glide.with(requireContext())
                .load(data[0].background)
                .apply( RequestOptions.placeholderOf(circularProgressDrawable)
                    .error(R.drawable.ic_error))
                .into(binding.splash)
            showLoading(true)
            Handler(Looper.getMainLooper()).postDelayed({
                if(onBoardingFinished()){
                    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                }else{
                    findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
                }
            },3000)
        })
    }
    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

}