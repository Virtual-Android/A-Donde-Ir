package com.virtual_android.a_donde_ir

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel () {

    private var poiList = MutableLiveData<List<Poi>>()
    private var apiServices = RetroFitFactory.apiServices()

    init {
        requestPois()
    }

    fun getPois(): LiveData<List<Poi>> = poiList

    private fun requestPois() {

    }
}