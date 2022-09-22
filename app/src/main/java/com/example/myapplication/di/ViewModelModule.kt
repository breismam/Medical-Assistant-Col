package com.example.myapplication.di

import com.example.myapplication.data.repositories.HomeRepository
import com.example.myapplication.data.viewmodels.HomeViewModel
import com.example.myapplication.data.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        LoginViewModel(get())
    }
    viewModel {
        HomeViewModel(get())
    }
}