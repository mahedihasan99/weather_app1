package com.mahedi.weather_app_0400034063

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahedi.weather_app_0400034063.adapters.ForecastAdapter
import com.mahedi.weather_app_0400034063.databinding.FragmentWeatherBinding
import com.mahedi.weather_app_0400034063.viewmodels.WeatherViewModel


class WeatherFragment : Fragment() {
    private lateinit var binding : FragmentWeatherBinding
    private val weatherViewModel: WeatherViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherBinding.inflate(inflater,container,false)
        val adapter = ForecastAdapter()
        binding.forecastRV.layoutManager =
            LinearLayoutManager(requireActivity()).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
        binding.forecastRV.adapter = adapter
        weatherViewModel.locationLiveData.observe(viewLifecycleOwner){
            weatherViewModel.fetchData()
        }
        weatherViewModel.currentLiveData.observe(viewLifecycleOwner){
            Log.d("WeatherFragment", "${it.main.temp}")
            binding.current = it
        }
        weatherViewModel.forecastLiveData.observe(viewLifecycleOwner){
            Log.d("ForecastWeather", "${it.list.size}")
            adapter.submitList(it.list)
        }
        return binding.root
    }
}