package com.appin.finalmvvmcleanarchitructureapp.domain.usecase

import com.appin.finalmvvmcleanarchitructureapp.domain.model.MyVehicleData
import com.appin.finalmvvmcleanarchitructureapp.domain.repository.VehicleRepository
import com.appin.finalmvvmcleanarchitructureapp.utils.Resource
import javax.inject.Inject


/**
 * Created by Kamlesh Patel on 22/10/24.
 */

class GetVehicleListUseCase @Inject constructor(private val vehicleRepository: VehicleRepository){
    suspend  operator fun invoke(): Resource<List<MyVehicleData>> {
        return vehicleRepository.getVehicleRepository()
    }
}