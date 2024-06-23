package com.sg.myweather.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sg.myweather.databinding.ActivityMainBinding
import com.sg.myweather.home.adapter.DailyAdapter
import com.sg.myweather.home.adapter.HourlyAdapter
import com.sg.myweather.home.model.DailyForecastModel
import com.sg.myweather.home.model.HourlyModel

class MainActivity : AppCompatActivity() {

    private lateinit var hourlyAdapter: HourlyAdapter
    private lateinit var dailyAdapter: DailyAdapter

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        val hourlyList = hourlyData()
        hourlyAdapter = HourlyAdapter(hourlyList)
        binding.rcvHourly.adapter = hourlyAdapter

        val dailyList = dailyForecastData()
        dailyAdapter = DailyAdapter(dailyList)
        binding.rcvDailyForecast.adapter = dailyAdapter
    }

    private fun hourlyData(): ArrayList<HourlyModel> {
        return arrayListOf(
            HourlyModel(type = 1, temp = 40, percent = 5),
            HourlyModel(type = 2, temp = 41, percent = 6),
            HourlyModel(type = 1, temp = 42, percent = 7),
            HourlyModel(type = 1, temp = 43, percent = 8),
            HourlyModel(type = 2, temp = 44, percent = 9),
            HourlyModel(type = 2, temp = 45, percent = 10),
        )
    }

    private fun dailyForecastData(): ArrayList<DailyForecastModel> {
        return arrayListOf(
            DailyForecastModel("Cloudy", 10, 10),
            DailyForecastModel("Cloudy", 10, 10),
            DailyForecastModel("Cloudy", 10, 10),
            DailyForecastModel("Cloudy", 10, 10),
            DailyForecastModel("Cloudy", 10, 10),
        )
    }
}