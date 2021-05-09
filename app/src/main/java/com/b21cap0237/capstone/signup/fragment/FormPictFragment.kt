package com.b21cap0237.capstone.signup.fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.b21cap0237.capstone.MainActivity
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentFormPictBinding
import com.b21cap0237.capstone.databinding.FragmentFormSignUpBinding


class FormPictFragment : Fragment() {
    private val pickImage = 100
    private var imageUri: Uri? = null
    private lateinit var binding: FragmentFormPictBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_pict, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentFormPictBinding.bind(view)

        binding.btnUploadFoto.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
            Toast.makeText(context, "Proses Upload", Toast.LENGTH_SHORT).show()
        }
        binding.btnSubmit.setOnClickListener {
            startActivity(Intent(context,MainActivity::class.java))
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            binding.imgProfil.setImageURI(imageUri)
        }
    }
}