package com.app.weatherforcast.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory<V>(private  val viewModel:V): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isInstance(viewModel)){
            viewModel as T
        }
        else{
            throw IllegalArgumentException("It's not a viewmoddel")
        }
    }

}