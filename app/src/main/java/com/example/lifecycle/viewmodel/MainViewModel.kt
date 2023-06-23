package com.example.lifecycle.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _counter = NumberLiveData()
    val counter: LiveData<Int> = _counter

    fun increment() {
        val number = _counter.value ?: 0
        _counter.value = number + 1
    }
}

class NumberLiveData(initial: Int = 0) : MutableLiveData<Int>(initial) {
    override fun onActive() {
        super.onActive()
        Log.d("MainViewModel", "onActive")
    }

    override fun onInactive() {
        super.onInactive()
        Log.d("MainViewModel", "onInactive")
    }
}

/* O que é LiveData? É uma classe armazenadora de dados view. Diferente de uma view comum, o
* LiveData conta com um reconhececiento de ciclo de vida, ou seja, ele respeita o ciclo de
* outros componentes do app, como Activitys, Framents ou Serviços. Esse reconhecimento, garante
* que o LiveData autalize apenas as views de componente do app que estão em estado ativo no
* lifecycle.*/