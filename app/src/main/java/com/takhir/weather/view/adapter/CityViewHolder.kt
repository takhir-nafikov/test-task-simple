package com.takhir.weather.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.takhir.weather.database.entity.CityEntity
import com.takhir.weather.databinding.LayoutCityItemBinding

class CityViewHolder(
  private val binding: LayoutCityItemBinding
) : RecyclerView.ViewHolder(binding.root) {

  fun bind(
    entity: CityEntity,
    listener: ((entity: CityEntity) -> Unit)?
  ) {
    binding.entity = entity
    binding.itemBox.setOnClickListener {
      listener?.invoke(entity)
    }
  }
}