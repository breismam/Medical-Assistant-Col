package com.example.myapplication.di

import com.example.myapplication.data.repositories.HomeRepository
import com.example.myapplication.data.repositories.LoginRepository
import org.koin.dsl.module

val repomodule = module {
    single { LoginRepository() }
    single {HomeRepository()}
}