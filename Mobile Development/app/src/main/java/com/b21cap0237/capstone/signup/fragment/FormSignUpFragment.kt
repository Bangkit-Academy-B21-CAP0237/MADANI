package com.b21cap0237.capstone.signup.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentFormSignUpBinding
import com.b21cap0237.capstone.databinding.FragmentHomeBinding
import com.b21cap0237.capstone.infodetail.viewmodel.InfoViewModel
import com.b21cap0237.capstone.login.LoginActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class FormSignUpFragment : Fragment() {
    private lateinit var binding: FragmentFormSignUpBinding
    private lateinit var infoViewModel: InfoViewModel
    private lateinit var circularProgressDrawable : CircularProgressDrawable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentFormSignUpBinding.bind(view)

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
                .into(binding.imageView)
        })

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(context,LoginActivity::class.java))
        }
        binding.btnSubmit.setOnClickListener {
            val formInstansiFragment = FormInstansiFragment()
            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.container,
                    formInstansiFragment,
                    FormInstansiFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}