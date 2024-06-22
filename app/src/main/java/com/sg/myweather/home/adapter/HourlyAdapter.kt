package com.sg.myweather.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sg.myweather.R
import com.sg.myweather.databinding.ItemHourlyBinding
import com.sg.myweather.home.model.HourlyModel

class HourlyAdapter(private var dataList: List<HourlyModel>) : RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hourly, parent, false)
        return HourlyViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {
        val model = dataList[position]
        holder.onBind(model)
    }

    class HourlyViewHolder(view: View) : ViewHolder(view) {
        private val binding = ItemHourlyBinding.bind(view)
        fun onBind(model: HourlyModel) {
            with(binding) {
                tvHourlyTemperature.text = model.temp.toString()
                tvHourlyPercent.text = model.percent.toString()
                if (model.type == 1) {
                    ivHourlyWeather.setImageResource(R.drawable.ic_sun_cloud)
                } else {
                    ivHourlyWeather.setImageResource(R.drawable.ic_sun_cloud_2)
                }
            }
        }
    }
}