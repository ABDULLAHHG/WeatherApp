package com.example.weatherapp

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresPermission
import com.example.weatherapp.presentation.screen.MainScreen
import com.example.weatherapp.presentation.screen.theme.WeatherAppTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : ComponentActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        setContent {
            WeatherAppTheme {
                MainScreen()
            }
        }
    }

//    @Composable
//    fun LocationScreen() {
//        var addressLine by remember { mutableStateOf("Fetching location...") }
//
//        LaunchedEffect(Unit) {
//            fusedLocationClient.lastLocation
//                .addOnSuccessListener { location: Location? ->
//                    if (location != null) {
//                        val geocoder = Geocoder(this@MainActivity, Locale.getDefault())
//                        val addresses: List<Address>? = geocoder.getFromLocation(location.latitude, location.longitude, 1)
//                        if (!addresses.isNullOrEmpty()) {
//                            val address = addresses[0]
//                            addressLine = address.getAddressLine(0) ?: "No address found"
//                        } else {
//                            addressLine = "No address found"
//                        }
//                    } else {
//                        addressLine = "Location not available"
//                    }
//                }
//                .addOnFailureListener {
//                    addressLine = "Failed to get location"
//                }
//        }
//
//        Text(
//            text = addressLine,
//            modifier = Modifier.padding(16.dp),
//            fontSize = 20.sp
//        )
//    }
}
