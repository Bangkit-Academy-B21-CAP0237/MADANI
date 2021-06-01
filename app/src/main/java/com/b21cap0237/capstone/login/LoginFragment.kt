package com.b21cap0237.capstone.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.b21cap0237.capstone.MainActivity
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentLoginBinding
import com.b21cap0237.capstone.signup.SignUpActivity
import kotlinx.android.synthetic.main.fragment_halaman_ketiga.*


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentLoginBinding.bind(view)

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