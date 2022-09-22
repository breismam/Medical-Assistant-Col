package com.example.myapplication.ui.fragments

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.interfaces.OnServiceClickListener
import com.example.myapplication.R
import com.example.myapplication.ui.adapters.ServiceAdapter
import com.example.myapplication.data.models.ServiceModel
import com.example.myapplication.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private lateinit var serviceAdapter: ServiceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        serviceAdapter= ServiceAdapter(
            listOf())

        serviceAdapter.listener= object: OnServiceClickListener {
            override fun onClick(item: ServiceModel) {

            }

        }
        binding.homeFragmentReclycer.apply {
            adapter= serviceAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}