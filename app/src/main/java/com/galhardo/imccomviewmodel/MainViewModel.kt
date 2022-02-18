package com.galhardo.imccomviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var _imc = MutableLiveData<String>().apply { value = imc.toString() }
    private var imc: Float = 0.0f


    private fun setValue() {
        _imc.value = imc.toString()
    }


    fun calculoIMC(peso: Float, altura: Float) {
        imc = (peso / (altura * altura))
        setValue()
    }

}

