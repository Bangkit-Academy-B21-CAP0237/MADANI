package com.b21cap0237.capstone.signup.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentFormInstansiBinding
import com.b21cap0237.capstone.databinding.FragmentHomeBinding


class FormInstansiFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentFormInstansiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_instansi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentFormInstansiBinding.bind(view)
        val spinner=binding.spinnerInstansi
        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.instansi_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}