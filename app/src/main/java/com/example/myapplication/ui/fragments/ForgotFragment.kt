package com.example.myapplication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentForgotBinding
import com.example.myapplication.isValidEmail


class ForgotFragment : Fragment() {
    private var _binding: FragmentForgotBinding? = null
    private val binding: FragmentForgotBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentForgotBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.fragmentForgotButton.setOnClickListener {
            if (!binding.forgotEmail.text.toString().isValidEmail()) {
                binding.forgotEmailLayout.error = getString(R.string.email_error)
            } else {
                binding.forgotEmailLayout.error = null
            }
            binding.fragmentForgotLabel2.setOnClickListener {
                findNavController().navigate(R.id.action_forgotFragment_to_signUpFragment)
            }
        }
    }
}
