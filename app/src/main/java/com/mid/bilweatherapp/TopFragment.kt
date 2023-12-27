package com.mid.bilweatherapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mid.bilweatherapp.databinding.FragmentTopBinding
import com.mid.bilweatherapp.db.DailyWeatherForecast
import com.squareup.picasso.Picasso

class TopFragment : Fragment() {
    private lateinit var binding: FragmentTopBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun updateView(currentTemp: Double, weather: DailyWeatherForecast) {
        binding.textTemp.text = currentTemp.toInt().toString() + getString(R.string.txtTemperatureShort)
        binding.textHumidity.text = weather.humidity + "%"
        binding.textWind.text = weather.wind_kph + " " + getString(R.string.txtWindSpeedMeasurement)

        Picasso.get().load("https://"+ weather.icon)
            .resize(100,100) //optional, Transform images to better fit into layouts and to reduce memory size.
            .centerCrop() //optional, Transform images to better fit into layouts and to reduce memory size.
            .error(R.drawable.sunny)//optional, Picasso supports both download and error placeholders as optional features
            .into(binding.weatherIcon) //taken image will be displayed on imgItemRecipe view.

        Log.i("FRAGMENT","Fragment updated")
    }
}