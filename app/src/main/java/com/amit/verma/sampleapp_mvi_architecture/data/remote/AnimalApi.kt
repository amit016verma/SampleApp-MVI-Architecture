package com.amit.verma.sampleapp_mvi_architecture.data.remote

import com.amit.verma.sampleapp_mvi_architecture.data.model.Animal
import retrofit2.http.GET

interface AnimalApi {

    @GET("animals.json")
    suspend fun getAnimals() : List<Animal>
}