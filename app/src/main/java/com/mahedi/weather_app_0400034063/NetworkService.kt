package com.mahedi.weather_app_0400034063

import com.mahedi.weather_app_0400034063.models.CurrentModel
import com.mahedi.weather_app_0400034063.models.ForecastModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Url
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

const val weather_api_key = "cec5ce73afcaf6a6ca0478d25e9ecd33"
const val base_url = "https://api.openweathermap.org/data/2.5/"
const val icon_prefix = "https://openweathermap.org/img/wn/"
const val icon_suffix = "@2x.png"


fun getFormattedDate(dt: Long, pattern: String): String {
    return SimpleDateFormat(pattern).format(Date(dt * 1000))
}

val retrofit = Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()


interface WeatherServiceApi {

    @GET
    suspend fun getCurrentWeather(@Url endUrl: String) : CurrentModel


    @GET
    suspend fun getForecastWeather(@Url endUrl: String) : ForecastModel
}

object NetworkService{

    val weatherServiceApi: WeatherServiceApi by lazy {
        retrofit.create(WeatherServiceApi :: class.java)
    }
}