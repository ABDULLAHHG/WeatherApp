package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.entity.LocationInfo
import com.example.weatherapp.logic.reposiotry.LocationRepository

class GetLocationUseCase(
    private val locationRepository: LocationRepository

) {
    suspend fun execute(): LocationInfo {
        return locationRepository.getCurrentLocation()
    }

}