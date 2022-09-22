package com.example.myapplication.data.datasources

import com.example.myapplication.data.models.ServiceModel

class MemoryDataSources {
    suspend fun getServices(): List<ServiceModel>{
    return   listOf(
    ServiceModel("1", "General", "Los mejores especialistas en medicina general",
    R.drawable.ico_general.toString()
    ),
    ServiceModel("2", "Especialista", "Los mejores especialistas",
    R.drawable.ico_espec.toString()
    ),
    ServiceModel("3", "Odontologia", "Los mejores especialistas en odontologia",
    R.drawable.ico_odon.toString()
    ),
    ServiceModel("4", "Dermatologia", "Los mejores especialistas en Dermatologia",
    R.drawable.ico_dermat.toString()
    ),
    ServiceModel("5", "Pediatría", "Los mejores especialistas en Pediatria",
    R.drawable.ico_pediatria.toString()
    )
    )
}
}