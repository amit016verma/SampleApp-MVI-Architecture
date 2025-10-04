package com.amit.verma.sampleapp_mvi_architecture.data.remote

class AnimalRepo(private val api : AnimalApi) {

    suspend fun getAnimals() = api.getAnimals()
}