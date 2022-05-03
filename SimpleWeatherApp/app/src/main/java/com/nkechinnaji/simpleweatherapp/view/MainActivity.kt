package com.nkechinnaji.simpleweatherapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nkechinnaji.simpleweatherapp.databinding.ActivityMainBinding
import com.nkechinnaji.simpleweatherapp.extensions.visibilityGone
import com.nkechinnaji.simpleweatherapp.extensions.visibilityVisible
import com.nkechinnaji.simpleweatherapp.viewmodel.CurrentWeatherViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : CurrentWeatherViewModel
    private lateinit var newAdapter: TopHeadLineNewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        fetchCurrentWeatherData()
        observeWeatherLiveData()
        showOrHideWeatherDataContainer()

        fetchTopHeadlineNewsData()
        observeNewsLiveData()
    }

    /**
     * Weather API call
     */
    private fun fetchCurrentWeatherData() {
        viewModel.fetchWeatherData("", "Omaha,Nebraska")
    }

    /**
     * News Api call
     */
    private fun fetchTopHeadlineNewsData(){
        viewModel.fetchTopHealineNews(accessKey = "", query = "weather")
    }

    /**
     * Weather Live data observing
     */
    private fun observeWeatherLiveData(){
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


    /**
     * Manage weather visibility
     */
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
                    fetchCurrentWeatherData()
                    observeWeatherLiveData()
                }

            }
        })
    }


    /**
     * News Live data observing
     */
    private fun observeNewsLiveData(){
        viewModel.headlineNewsData.observe(this, Observer{ data ->
            if(data == null)return@Observer
            data.let {
                if(data.articles!= null) {
                    newAdapter = TopHeadLineNewsAdapter(it.articles)
                    binding.newsRecyclerview.adapter = newAdapter
                }
            }

        })
    }

}
