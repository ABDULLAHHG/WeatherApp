package com.example.weatherapp.data.repository

import android.Manifest
import androidx.annotation.RequiresPermission
import com.example.weatherapp.data.datasource.LocationDataSource
import com.example.weatherapp.logic.entity.LocationInfo
import com.example.weatherapp.logic.reposiotry.LocationRepository

class LocationRepositoryImpl(
    private val dataSource: LocationDataSource
) : LocationRepository {

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override suspend fun getCurrentLocation(): LocationInfo {
        return dataSource.getCurrentLocation()
    }

}

