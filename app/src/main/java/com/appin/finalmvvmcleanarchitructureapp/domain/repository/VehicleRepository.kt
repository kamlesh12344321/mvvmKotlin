package com.appin.finalmvvmcleanarchitructureapp.domain.repository

import com.appin.finalmvvmcleanarchitructureapp.domain.model.MyVehicleData
import com.appin.finalmvvmcleanarchitructureapp.utils.Resource


/**
 * Created by Kamlesh Patel on 22/10/24.
 */
interface VehicleRepository {
    suspend fun getVehicleRepository():Resource<List<MyVehicleData>>
}