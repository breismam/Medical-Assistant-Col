package com.example.myapplication.interfaces

import com.example.myapplication.data.models.DoctorModel

interface OnDoctorClickListener {
    fun onClick(item: DoctorModel)
}