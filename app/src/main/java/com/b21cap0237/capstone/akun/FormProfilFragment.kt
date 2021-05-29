package com.b21cap0237.capstone.akun

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.b21cap0237.capstone.MainActivity
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentFormProfilBinding


class FormProfilFragment : Fragment() {

    private val pickImage = 100
    private var imageUri: Uri? = null
    private lateinit var profilBinding: FragmentFormProfilBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profilBinding = FragmentFormProfilBinding.bind(view)

        val spinner = profilBinding.edtInstansi
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

        profilBinding.btnUploadFoto.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
            Toast.makeText(context, "Proses Upload", Toast.LENGTH_SHORT).show()
        }

        profilBinding.btnSubmit.setOnClickListener {
            Toast.makeText(context, "Profil di perbarui", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            profilBinding.imgProfil.setImageURI(imageUri)
        }
    }
}