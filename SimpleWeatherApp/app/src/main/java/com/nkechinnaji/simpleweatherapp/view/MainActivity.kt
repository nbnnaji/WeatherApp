package com.nkechinnaji.simpleweatherapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nkechinnaji.simpleweatherapp.databinding.ActivityMainBinding
import com.nkechinnaji.simpleweatherapp.extensions.visibilityGone
import com.nkechinnaji.simpleweatherapp.extensions.visibilityVisible
import com.nkechinnaji.simpleweatherapp.viewmodel.CurrentWeatherViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : CurrentWeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        viewModel.fetchWeatherData("", "Omaha,Nebraska")
        getCurrentWeatherData()
        showOrHideWeatherDataContainer()
    }

    private fun getCurrentWeatherData(){
        viewModel.weatherData.observe(this, Observer { data ->
            data?.let {
                binding.weatherTemperature.text = (9.0 / 5.0 * (it.current?.temperature!!) + 32.0).toInt().toString().plus("\u2109")
                binding.windSpeed.text = "Wind speed: ${it.current!!.wind_speed.toString()}"
                binding.windDirection.text = "Wind direction: ${it.current!!.wind_dir}"
                binding.windFeeling.text = "Feels like: ${(9.0 / 5.0 * (it.current!!.feelslike) + 32.0).toInt()}".plus("\u2109")
                binding.weatherVisibility.text = "Visibility: ${it.current!!.visibility.toString()}"
                binding.weatherHumidity.text = "Humidity: ${it.current!!.humidity.toString()}"
                binding.weatherDesc.text = it.current!!.weather_descriptions[0]
                binding.weatherLocation.text = it.location?.name
            }
        })
    }

    private fun showOrHideWeatherDataContainer(){
        viewModel.showData.observe(this, Observer { isDataAvailable ->
            if(isDataAvailable == null) return@Observer
            if(isDataAvailable == true){
                binding.dataErrorContainer.root.visibilityGone()
                binding.weatherContainer.visibilityVisible()
            } else{
                binding.dataErrorContainer.root.visibilityVisible()
                binding.weatherContainer.visibilityGone()
                binding.dataErrorContainer.tryAgainBtn.setOnClickListener{
                    getCurrentWeatherData()
                }

            }
        })
    }
}
