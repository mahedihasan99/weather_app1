package com.mahedi.weather_app_0400034063.repos

import android.location.Location
import com.mahedi.weather_app_0400034063.NetworkService
import com.mahedi.weather_app_0400034063.models.CurrentModel
import com.mahedi.weather_app_0400034063.models.ForecastModel
import com.mahedi.weather_app_0400034063.weather_api_key

class WeatherRepository {

    suspend fun fetchCurrentData(location: Location): CurrentModel {
        val endUrl =
            "weather?lat=${location.latitude}&lon=${location.longitude}&units=metric&appid=$weather_api_key"
        return NetworkService.weatherServiceApi
            .getCurrentWeather(endUrl)
    }

    suspend fun fetchForecastData(location: Location): ForecastModel {
        val endUrl =
            "forecast?lat=${location.latitude}&lon=${location.longitude}&units=metric&appid=$weather_api_key"
        return NetworkService.weatherServiceApi
            .getForecastWeather(endUrl)
    }
}