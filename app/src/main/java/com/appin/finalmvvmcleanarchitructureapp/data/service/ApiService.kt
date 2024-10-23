package com.appin.finalmvvmcleanarchitructureapp.data.service

import com.appin.finalmvvmcleanarchitructureapp.data.model.VehicalResponseX
import retrofit2.Response
import retrofit2.http.GET


/**
 * Created by Kamlesh Patel on 22/10/24.
 */
interface ApiService {

    @GET("vehicles/")
    suspend fun getVehicleList(): Response<VehicalResponseX>

}