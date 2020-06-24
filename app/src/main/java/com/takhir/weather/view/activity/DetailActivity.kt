package com.takhir.weather.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.takhir.weather.R
import com.takhir.weather.database.entity.CityEntity
import com.takhir.weather.databinding.ActivityDetailBinding
import com.takhir.weather.viewmodel.DetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

  private val detailViewModel by viewModel<DetailViewModel>()

  private val entity: CityEntity?
    get() = intent.extras?.getParcelable(MainActivity.ENTITY_KEY)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    DataBindingUtil
      .setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
      .apply {
        viewModel = detailViewModel

        detailViewModel.setEntity(entity)

        MainActivity.initSpinner(
          spinnerCityType,
          this@DetailActivity,
          R.array.min_city_type
        ) {detailViewModel.setType(it)}

        btnAdd.setOnClickListener { detailViewModel.addEntity() }
        btnUpdate.setOnClickListener { detailViewModel.updateEntity() }
        btnDelete.setOnClickListener { detailViewModel.deleteEntity() }
      }
  }
}