package com.appin.finalmvvmcleanarchitructureapp.di

import com.appin.finalmvvmcleanarchitructureapp.data.mappers.VehicleMappers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Created by Kamlesh Patel on 22/10/24.
 */
@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideVehicleMappers(): VehicleMappers {
        return VehicleMappers()
    }
}