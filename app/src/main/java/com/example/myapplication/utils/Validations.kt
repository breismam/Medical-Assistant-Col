package com.example.myapplication

import android.text.TextUtils
import android.util.Patterns
import java.util.regex.Pattern

fun String.isValidEmail(): Boolean{
   return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPassword(): Boolean{
   return this.length >= 8
}

fun String.isValidNombre(): Boolean{
   return !TextUtils.isEmpty(this) && Patterns.DOMAIN_NAME.matcher(this).matches()
}