package com.amit.verma.sampleapp_mvi_architecture.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amit.verma.sampleapp_mvi_architecture.data.remote.AnimalApi
import com.amit.verma.sampleapp_mvi_architecture.data.remote.AnimalRepo
import com.amit.verma.sampleapp_mvi_architecture.ui.MainViewModel
import kotlin.jvm.java

class ViewModelFactory(
    private val api: AnimalApi
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(AnimalRepo(api)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}