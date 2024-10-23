package com.appin.finalmvvmcleanarchitructureapp.presentation

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appin.finalmvvmcleanarchitructureapp.R
import com.appin.finalmvvmcleanarchitructureapp.adapters.VehicleListAdapter
import com.appin.finalmvvmcleanarchitructureapp.domain.model.MyVehicleData
import com.appin.finalmvvmcleanarchitructureapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:VehiclesViewModel
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter: VehicleListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progress_circular)
        recyclerView = findViewById(R.id.recycler_view)
        viewModel = ViewModelProvider(this).get(VehiclesViewModel::class)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel.vehicleList.observe(this, Observer { resource->
            when(resource) {
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Error -> {
                    progressBar.visibility = View.VISIBLE
                    Toast.makeText(this, "Api call error", Toast.LENGTH_LONG).show()
                }
                is Resource.Success -> {
                    progressBar.visibility = View.GONE
                   setupRecyclerView(resource.data)
                }
            }
        })
        viewModel.fatchVehicleData()
    }

    private fun setupRecyclerView(data: List<MyVehicleData>?) {
        adapter = VehicleListAdapter(data!!)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}