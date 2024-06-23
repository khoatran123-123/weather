package com.sg.myweather.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sg.myweather.R
import com.sg.myweather.databinding.ItemDailyBinding
import com.sg.myweather.home.model.DailyForecastModel

class DailyAdapter(private val dataList: ArrayList<DailyForecastModel>) :
    RecyclerView.Adapter<DailyAdapter.DailyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_daily, parent, false)
        return DailyViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        val model = dataList[position]
        holder.onBind(model)
    }

    class DailyViewHolder(view: View) : ViewHolder(view) {
        private val binding = ItemDailyBinding.bind(view)
        fun onBind(model: DailyForecastModel) {
            with(binding) {
                tvHighTemp.text = "${model.highTemp}°"
                tvLowTemp.text = "${model.lowTemp}°"
                tvWeather.text = model.weather
            }
        }
    }
}