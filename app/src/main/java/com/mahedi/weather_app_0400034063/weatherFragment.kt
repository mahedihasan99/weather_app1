package com.mahedi.weather_app_0400034063

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.mahedi.weather_app_0400034063.viewmodels.WeatherViewModel


class weatherFragment : Fragment() {
    private val weatherViewModel: WeatherViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        weatherViewModel.locationLiveData.observe(viewLifecycleOwner){

        }
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }
}