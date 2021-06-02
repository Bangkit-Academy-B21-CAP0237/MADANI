package com.b21cap0237.capstone.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.b21cap0237.capstone.MainActivity
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentLoginBinding
import com.b21cap0237.capstone.infodetail.viewmodel.InfoViewModel
import com.b21cap0237.capstone.signup.SignUpActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var infoViewModel: InfoViewModel
    private lateinit var circularProgressDrawable : CircularProgressDrawable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentLoginBinding.bind(view)

        circularProgressDrawable = context?.let { CircularProgressDrawable(it) }!!
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        infoViewModel= ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            InfoViewModel::class.java)

        infoViewModel.setInfoDetail()
        infoViewModel.getKondisi().observe(viewLifecycleOwner,{data->
            Glide.with(requireContext())
                .load(data[0].gambarAplikasi)
                .apply( RequestOptions.placeholderOf(circularProgressDrawable)
                    .error(R.drawable.ic_error))
                .into(binding.logo)
        })

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(activity,MainActivity::class.java))
            activity?.finish()
        }
        binding.btnNewAccount.setOnClickListener {
            startActivity(Intent(activity, SignUpActivity::class.java))
            activity?.finish()
        }
    }

}