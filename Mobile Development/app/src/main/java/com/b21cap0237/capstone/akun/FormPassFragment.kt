package com.b21cap0237.capstone.akun

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentFormPassBinding
import kotlinx.android.synthetic.main.fragment_halaman_ketiga.*

class FormPassFragment : Fragment() {

    private lateinit var passBinding: FragmentFormPassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.edit_password)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            16908332->{
                activity?.onBackPressed()
                true
            }
            else -> true
        }
    }
}