package com.appin.finalmvvmcleanarchitructureapp.di

import com.appin.finalmvvmcleanarchitructureapp.data.repository.VehicleRepositoryImpl
import com.appin.finalmvvmcleanarchitructureapp.domain.repository.VehicleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Created by Kamlesh Patel on 22/10/24.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindVehicleRepository(vehicleRepositoryImpl: VehicleRepositoryImpl):VehicleRepository
}