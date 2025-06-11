package com.example.weatherapp.data.datasource

import android.Manifest
import android.location.Address
import android.location.Geocoder
import android.location.Location
import androidx.annotation.RequiresPermission
import com.example.weatherapp.logic.entity.LocationInfo
import com.example.weatherapp.logic.reposiotry.LocationRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.Priority
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.resumeWithException

class LocationDataSource(
    private val fusedLocationClient: FusedLocationProviderClient,
    private val geocoder: Geocoder
) : LocationRepository {


    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override suspend fun getCurrentLocation(): LocationInfo {
        return try {
            val location = fusedLocationClient.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY,
                null
            ).await()
            val safeLocation = location ?: getFreshLocation()


            val cityName = getCityNameFromLatLng(safeLocation.latitude, safeLocation.longitude)
            LocationInfo(
                latitude = safeLocation.latitude,
                longitude = safeLocation.longitude,
                cityName = cityName
            )
        } catch (e: Exception) {
            throw e
        }
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    private suspend fun getFreshLocation(): Location = suspendCancellableCoroutine { cont ->
        val request = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 1000).apply {
            setMinUpdateIntervalMillis(500)
            setMaxUpdates(1)
        }.build()

        val callback = object : LocationCallback() {
            override fun onLocationResult(result: LocationResult) {
                fusedLocationClient.removeLocationUpdates(this)
                val location = result.lastLocation
                if (location != null) {
                    cont.resume(location, null)
                } else {
                    cont.resumeWithException(Exception("Fresh location was null"))
                }
            }
        }
        fusedLocationClient.requestLocationUpdates(request, callback, null)
    }

    private fun getCityNameFromLatLng(latitude: Double, longitude: Double): String {
        return try {
            val addresses: List<Address>? = geocoder.getFromLocation(latitude, longitude, 1)

            if (!addresses.isNullOrEmpty()) {
                addresses[0].locality
                    ?: addresses[0].subAdminArea
                    ?: addresses[0].adminArea
                    ?: throw Exception()
            } else {
                throw Exception()
            }
        } catch (e: Exception) {
            throw Exception()
        }
    }
}