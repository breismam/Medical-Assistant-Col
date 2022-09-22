package com.example.myapplication.data.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repositories.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: LoginRepository):ViewModel() {
    private var _login: MutableLiveData<Boolean> = MutableLiveData()
    val login: LiveData<Boolean> get() = _login

    fun login(email:String, password: String){

      viewModelScope.launch {
          try {
          repo.login(email,password)
          _login.postValue(true)
      }catch (e: Exception){
              _login.postValue(false)
          }

  }
    }
}