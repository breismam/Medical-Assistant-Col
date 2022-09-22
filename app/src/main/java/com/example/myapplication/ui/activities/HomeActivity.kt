package com.example.myapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.homeToolbar)
    }
    override fun onStart() {
        super.onStart()
        val navController = findNavController(R.id.nav_host_home_fragment)
 //       val appBarConfiguration = AppBarConfiguration(
 //           setOf(
  //              R.id.homeFragment,
  //              R.id.specialistFragment,
 //               R.id.locationFragment,
 //               R.id.profileFragment,

 //           )
//        )
        binding.homeNavigation.setupWithNavController(navController)
        binding.homeToolbar.setupWithNavController(navController)

    }
}