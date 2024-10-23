package com.appin.finalmvvmcleanarchitructureapp.presentation

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appin.finalmvvmcleanarchitructureapp.domain.model.MyVehicleData
import com.appin.finalmvvmcleanarchitructureapp.domain.usecase.GetVehicleListUseCase
import com.appin.finalmvvmcleanarchitructureapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Kamlesh Patel on 22/10/24.
 */
@HiltViewModel
class VehiclesViewModel @Inject constructor(
    private val vehicleListUseCase: GetVehicleListUseCase
): ViewModel(){
    private val _vehicles = MutableLiveData<Resource<List<MyVehicleData>>>()
    val vehicleList:LiveData<Resource<List<MyVehicleData>>> get() = _vehicles

    fun fatchVehicleData() {
        viewModelScope.launch {
            _vehicles.value = Resource.Loading()
            val result = vehicleListUseCase()
            _vehicles.value = result
        }
    }
}