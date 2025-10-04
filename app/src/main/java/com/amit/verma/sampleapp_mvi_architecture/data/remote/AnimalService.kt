package com.amit.verma.sampleapp_mvi_architecture.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AnimalService {

    const val BASE_URL = "https://raw.githubusercontent.com/CatalinStefan/animalAPI/master/"

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api : AnimalApi = getRetrofit().create(AnimalApi::class.java)
}