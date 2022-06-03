package com.mahedi.weather_app_0400034063.viewmodels

import android.location.Location
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahedi.weather_app_0400034063.NetworkService
import com.mahedi.weather_app_0400034063.models.CurrentModel
import com.mahedi.weather_app_0400034063.models.ForecastModel
import com.mahedi.weather_app_0400034063.repos.WeatherRepository
import com.mahedi.weather_app_0400034063.weather_api_key
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {
    val repository = WeatherRepository()
    val locationLiveData : MutableLiveData<Location> = MutableLiveData()
    val currentLiveData : MutableLiveData<CurrentModel> = MutableLiveData()
    val forecastLiveData : MutableLiveData<ForecastModel> = MutableLiveData()

    fun setNewLocation(location: Location){
        locationLiveData.value = location
    }

    fun fetchData(){
        viewModelScope.launch {
            try {
                currentLiveData.value = repository.fetchCurrentData(locationLiveData.value!!)
                forecastLiveData.value = repository.fetchForecastData(locationLiveData.value!!)
            }catch (e: Exception){
               Log.d("WeatherViewModel", e.localizedMessage)
            }
        }
    }
}