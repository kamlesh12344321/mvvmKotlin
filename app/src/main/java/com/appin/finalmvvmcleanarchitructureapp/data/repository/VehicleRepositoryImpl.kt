package com.appin.finalmvvmcleanarchitructureapp.data.repository

import com.appin.finalmvvmcleanarchitructureapp.data.mappers.VehicleMappers
import com.appin.finalmvvmcleanarchitructureapp.data.model.VehicalResponseX
import com.appin.finalmvvmcleanarchitructureapp.data.service.ApiService
import com.appin.finalmvvmcleanarchitructureapp.domain.model.MyVehicleData
import com.appin.finalmvvmcleanarchitructureapp.domain.repository.VehicleRepository
import com.appin.finalmvvmcleanarchitructureapp.utils.Resource
import retrofit2.Response
import javax.inject.Inject


/**
 * Created by Kamlesh Patel on 22/10/24.
 */
class VehicleRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mappers: VehicleMappers
): VehicleRepository {
    override suspend fun getVehicleRepository(): Resource<List<MyVehicleData>> {
       return try {
           val response: Response<VehicalResponseX> = apiService.getVehicleList()
           if (response.isSuccessful && response.body() != null){
               val vehicles = mappers.mapFromResponseList(responseList = response.body()!!.results)
               Resource.Success(vehicles)
           } else {
               Resource.Error("No Data Found")
           }
       } catch (e:Exception){
           Resource.Error("No Data Found")
       }
    }
}