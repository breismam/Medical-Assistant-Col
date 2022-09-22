package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.ui.adapters.DoctorAdapter
import com.example.myapplication.data.models.DoctorModel
import com.example.myapplication.interfaces.OnDoctorClickListener
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSpecialistBinding

class SpecialistFragment : Fragment() {

    private var _binding: FragmentSpecialistBinding? = null
    private val binding: FragmentSpecialistBinding get() = _binding!!
    private val args: SpecialistFragmentArgs by navArgs()
    private lateinit var doctorAdapter: DoctorAdapter
    private lateinit var doctorList: List<DoctorModel>
    private lateinit var originalList: List<DoctorModel>
    private lateinit var categories: List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpecialistBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        categories = listOf(
            "Todos","Dermatologa","Oncologa","Pediatra", "Cardiologo"
        )
        originalList = listOf(
            DoctorModel(
                "1", "Dra Katherine Rios", "Dermatologa", "500 + 200 pacientes", R.drawable.m2.toString(), 5.0, "Katherine Rios dermatologa reconocida"
            ),
            DoctorModel(
                "2", "Dra Daniela Arambuscay", "Oncologa", "500 + 200 pacientes", R.drawable.m3.toString(), 5.0, "Daniela Arambuscay Oncologa reconocida"
            ),
            DoctorModel(
                "3", "Dr Roger Samuel", "Pediatra", "500 + 200 pacientes", R.drawable.m4.toString(), 5.0, "Roger Samuel Pediatra reconocido"
            ),
            DoctorModel(
                "4", "Dra Ingryd Laverde", "Cardiologo", "500 + 200 pacientes", R.drawable.m5.toString(), 5.0, "Ingryd Laverde Cardiologa reconocido"
            ),
            DoctorModel(
                "5", "Dr Juan Pablo Motta Laverde", "Cardiologo", "500 + 200 pacientes", R.drawable.m5.toString(), 5.0, "Juan Pablo Motta Cardiologo reconocido"
            )
        )

        doctorList= listOf(
            DoctorModel(
                "1", "Dra Katherine Rios", "Dermatologa", "500 + 200 pacientes", R.drawable.m2.toString(), 5.0, "Katherine Rios dermatologa reconocida"
            ),
            DoctorModel(
                "2", "Dra Daniela Arambuscay", "Oncologa", "500 + 200 pacientes", R.drawable.m3.toString(), 5.0, "Daniela Arambuscay Oncologa reconocida"
            ),
            DoctorModel(
                "3", "Dr Roger Samuel", "Pediatra", "500 + 200 pacientes", R.drawable.m4.toString(), 5.0, "Roger Samuel Pediatra reconocido"
            ),
            DoctorModel(
                "4", "Dra Ingryd Laverde", "Cardiologo", "500 + 200 pacientes", R.drawable.m5.toString(), 5.0, "Ingryd Laverde Cardiologa reconocido"
            ),
            DoctorModel(
                "5", "Dr Juan Pablo Motta Laverde", "Cardiologo", "500 + 200 pacientes", R.drawable.m5.toString(), 5.0, "Juan Pablo Motta Cardiologo reconocido"
            )
        )

        if(args.search){
            binding.specialistFragmentSearch.visibility = View.VISIBLE
            binding.specialistFragmentTitleList.visibility = View.GONE
            binding.specialistFragmentTitle.text= getString(R.string.specialist_fragment_title)
            binding.specialistFragmentSubtitle.text= getString(R.string.specialist_fragment_subtitle)
        } else{
            binding.specialistFragmentSearch.visibility = View.GONE
            binding.specialistFragmentTitleList.visibility = View.VISIBLE
            binding.specialistFragmentTitle.text=args.name
            doctorList = originalList.filter { x -> x.speciality==args.name }
            binding.specialistFragmentSubtitle.text= args.description

        }
        doctorAdapter = DoctorAdapter(doctorList)
        doctorAdapter.listener = object: OnDoctorClickListener {
            override fun onClick(item: DoctorModel) {
                Log.d("Hola", item.name)
            }
        }

        binding.specialistFragmentSearchAutocomplete.setAdapter(
            ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,categories))
        binding.specialistFragmentSearchAutocomplete.setOnItemClickListener { parent, view, position, id ->
            val category = categories[position]
            if(category != "Todos")

                doctorList = originalList.filter { x-> x.speciality == category }

            else

                doctorList = originalList
                doctorAdapter.changeDataSet(doctorList)

            }


        binding.homeFragmentReclycer.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = doctorAdapter
        }

    }


}
