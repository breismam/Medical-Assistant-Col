package com.example.myapplication.ui.fragments

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.CAMERA_PERMISSION
import com.example.myapplication.ui.activities.LoginActivity
import com.example.myapplication.TAKE_PICTURE
import com.example.myapplication.checkPermission
import com.example.myapplication.databinding.FragmentProfileBinding
import com.google.android.material.snackbar.Snackbar


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.profileFragmentName.text="Miller Rodríguez"
        binding.profileFragmentEmail.text="miller_m220@hotmail.com"
        binding.profileFragmentGender.text="Masculino"

        binding.profileFragmentLogout.setOnClickListener{
            val intent= Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            requireActivity().finish()
        }

        binding.profileFragmentImage.setOnClickListener {
            if(this.checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION )){
                openCamera()
            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == CAMERA_PERMISSION && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            openCamera()
        } else {
            Snackbar.make(binding.root,"Permiso no otorgado", Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == TAKE_PICTURE){
            if(data != null && data.extras!=null){
                val extras = data.extras!!
                val image= extras["data"] as Bitmap?
                binding.profileFragmentImage.setImageBitmap(image)



            }
        }
    }
    private fun openCamera(){

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
        startActivityForResult(intent, TAKE_PICTURE)
        } catch (e:ActivityNotFoundException){}
    }

}