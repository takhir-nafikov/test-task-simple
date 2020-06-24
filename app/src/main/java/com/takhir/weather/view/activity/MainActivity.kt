package com.takhir.weather.view.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.takhir.weather.R
import com.takhir.weather.database.entity.CityEntity
import com.takhir.weather.databinding.ActivityMainBinding
import com.takhir.weather.view.adapter.CityListAdapter
import com.takhir.weather.viewmodel.HandlerAdapter
import com.takhir.weather.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), HandlerAdapter {
  companion object {
    const val ENTITY_KEY = "entity"

    fun initSpinner(spinner: Spinner, context: Context, value: Int, function: (pos: Int) -> Unit) {
      val adapter: ArrayAdapter<CharSequence> =
        ArrayAdapter.createFromResource(context, value, android.R.layout.simple_spinner_item)
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

      spinner.tag = 0
      spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {}

        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
          if (spinner.tag != p2) {
            spinner.tag = p2
            function.invoke(p2)
          }
        }
      }

      spinner.adapter = adapter
    }
  }

  private val viewModel by viewModel<MainViewModel>()

  private val cityListAdapter: CityListAdapter by lazy {
    CityListAdapter().apply {
      onItemClickListener = {
        viewModel.toDetailActivity(it)
      }
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    DataBindingUtil
      .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
      .apply {


        recyclerView.run {
          layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
          adapter = cityListAdapter
        }

        initSpinner(spinnerCityType, this@MainActivity, R.array.city_type) { viewModel.chooseCityType(it) }

        viewModel.run {
          setHandler(this@MainActivity)
          getAllCities()
        }

        btnDetail.setOnClickListener {
          viewModel.toDetailActivity(null)
        }
      }
  }

  override fun add(data: List<CityEntity>) {
    cityListAdapter.addData(data)
  }
}