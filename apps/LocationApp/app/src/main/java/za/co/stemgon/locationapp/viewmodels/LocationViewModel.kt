package za.co.stemgon.locationapp.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import za.co.stemgon.locationapp.models.LocationData

class LocationViewModel: ViewModel() {
    private val _locationData = mutableStateOf<LocationData?>(null)
    public val locationData: State<LocationData?> = _locationData

    fun updateLocation(newLocationData: LocationData){
        _locationData.value = newLocationData
    }

}