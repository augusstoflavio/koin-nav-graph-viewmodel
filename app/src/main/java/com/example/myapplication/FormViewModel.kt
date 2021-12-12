package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormViewModel: ViewModel() {

    private val _currentValue = MutableLiveData("Valor Default")
    val currentValue: LiveData<String> = _currentValue

    fun setValue(value: String) {
        _currentValue.value = value
    }
}