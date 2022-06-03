package com.mahedi.weather_app_0400034063.viewmodels

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeatherViewModel: ViewModel() {
    val locationLiveData : MutableLiveData<Location> = MutableLiveData()

    fun setNewLocation(location: Location){
        locationLiveData.value = location
    }
}