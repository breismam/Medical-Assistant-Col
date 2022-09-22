package com.example.myapplication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSignUpBinding
import com.example.myapplication.isValidEmail
import com.example.myapplication.isValidNombre
import com.example.myapplication.isValidPassword

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding: FragmentSignUpBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.fragmentSigupButton.setOnClickListener {
            if(!binding.signupEmail.text.toString().isValidEmail()){
                binding.signupEmailLayout.error = getString(R.string.email_error)
            } else {
                binding.signupEmailLayout.error=null
            }
            if(!binding.signupPassword.text.toString().isValidPassword()){
                binding.signupPasswordLayout.error = getString(R.string.password_error)
            } else {
                binding.signupPasswordLayout.error=null
            }
            if(!binding.signupName.text.toString().isValidNombre()){
                binding.signupNameLayout.error = getString(R.string.nombre_invalido)
            } else {
                binding.signupNameLayout.error=null
            }
        }
        binding.fragmentSigupLabel2.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }
    }


}