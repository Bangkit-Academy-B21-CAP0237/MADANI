package com.b21cap0237.capstone.akun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentFormPassBinding

class FormPassFragment : Fragment() {

    private lateinit var passBinding: FragmentFormPassBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_pass, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passBinding = FragmentFormPassBinding.bind(view)

        passBinding.btnSubmit.setOnClickListener {
            Toast.makeText(context, "Perubahan tersimpan", Toast.LENGTH_SHORT).show()
        }
    }

}