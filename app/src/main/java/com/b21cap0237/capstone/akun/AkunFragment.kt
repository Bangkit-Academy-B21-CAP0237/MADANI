package com.b21cap0237.capstone.akun

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.b21cap0237.capstone.MainActivity
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentAkunBinding
import com.b21cap0237.capstone.databinding.FragmentLoginBinding
import com.b21cap0237.capstone.signup.SignUpActivity
import com.b21cap0237.capstone.signup.fragment.FormInstansiFragment


class AkunFragment : Fragment() {

    private lateinit var binding: FragmentAkunBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.hal_profile)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_akun, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAkunBinding.bind(view)

        binding.btnEditProfile.setOnClickListener {
            val formProfilFragment = FormProfilFragment()
            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.container,
                    formProfilFragment,
                    FormProfilFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }

        binding.btnEditPass.setOnClickListener {
            val formPassFragment = FormPassFragment()
            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.container,
                    formPassFragment,
                    FormPassFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}