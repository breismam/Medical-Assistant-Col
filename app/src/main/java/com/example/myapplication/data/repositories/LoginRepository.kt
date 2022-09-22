package com.example.myapplication.data.repositories

import kotlinx.coroutines.delay

class LoginRepository {
    suspend fun login(email:String, password:String){
        delay(2000)
        if (email!= "miller_m220@hotmail.com" || password!= "12345678"){
            throw Exception("Credenciales invalidas")
        }
    }
}