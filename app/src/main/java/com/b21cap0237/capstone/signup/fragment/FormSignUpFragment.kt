package com.b21cap0237.capstone.signup.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentFormSignUpBinding
import com.b21cap0237.capstone.databinding.FragmentHomeBinding
import com.b21cap0237.capstone.login.LoginActivity


class FormSignUpFragment : Fragment() {
    private lateinit var binding: FragmentFormSignUpBinding
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