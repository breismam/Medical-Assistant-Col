package com.example.myapplication.data.models

data class DoctorModel (
    val id: String,
    val name:String,
    val speciality: String,
    val caption: String,
    val image: String,
    val star: Double,
    val description: String
)