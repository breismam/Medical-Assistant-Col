package com.example.myapplication.interfaces

import com.example.myapplication.data.models.ServiceModel


interface OnServiceClickListener {
    fun onClick(item: ServiceModel)
}