package com.takhir.weather.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.takhir.weather.R
import com.takhir.weather.database.entity.CityEntity
import com.takhir.weather.databinding.LayoutCityItemBinding

class CityListAdapter() : RecyclerView.Adapter<CityViewHolder>() {

  private val cities: ArrayList<CityEntity> = ArrayList()

  var onItemClickListener: ((entity: CityEntity) -> Unit)? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    LayoutInflater.from(parent.context).let {
      val binding = DataBindingUtil
        .inflate<LayoutCityItemBinding>(it, R.layout.layout_city_item, parent, false)


      CityViewHolder(binding)
    }

  override fun getItemCount() =
    cities.size

  override fun onBindViewHolder(holder: CityViewHolder, position: Int) =
    holder.bind(cities[position], onItemClickListener)

  fun addData(data: List<CityEntity>) {
    cities.clear()
    cities.addAll(data)

    notifyDataSetChanged()
  }
}