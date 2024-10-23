package com.appin.finalmvvmcleanarchitructureapp.data.mappers

import com.appin.finalmvvmcleanarchitructureapp.data.model.VehicalResponseX
import com.appin.finalmvvmcleanarchitructureapp.data.model.VehivalResults
import com.appin.finalmvvmcleanarchitructureapp.domain.model.MyVehicleData


/**
 * Created by Kamlesh Patel on 22/10/24.
 */
class VehicleMappers {
    fun mapFromResponseList(responseList: List<VehivalResults>): List<MyVehicleData> {
        return responseList.map { mapFromResponse(it) }
    }

    fun mapFromResponse(response: VehivalResults): MyVehicleData {
        return MyVehicleData(
            name = response.name,
            model = response.model,
            manufacturer = response.manufacturer,
            cost_in_credits = response.cost_in_credits,
            length = response.length,
            max_atmosphering_speed = response.max_atmosphering_speed,
            crew = response.crew,
            passengers = response.passengers,
            cargo_capacity = response.cargo_capacity,
            consumables = response.consumables,
            vehicle_class = response.vehicle_class,
            pilots = response.pilots,
            films = response.films,
            created = response.created,
            edited = response.edited,
            url = response.url
        )
    }
}