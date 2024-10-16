package za.co.stemgon.locationapp

import android.app.Instrumentation.ActivityResult
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import za.co.stemgon.locationapp.ui.theme.LocationAppTheme
import za.co.stemgon.locationapp.utils.LocationUtils
import za.co.stemgon.locationapp.viewmodels.LocationViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val locationViewModel:LocationViewModel = viewModel()
            LocationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //
                    LocationUI(locationViewModel)
                }
            }
        }
    }
}

@Composable
fun LocationUI(
    locationViewModel: LocationViewModel
){
    val context = LocalContext.current
    val locationUtils: LocationUtils = LocationUtils(context)
    val locationData = locationViewModel.locationData.value

    val requestActivityLauncher =  rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = {
            permissions ->
            if (permissions[android.Manifest.permission.ACCESS_COARSE_LOCATION] == true
                && permissions[android.Manifest.permission.ACCESS_FINE_LOCATION] == true){
                locationUtils.requestLocationUpdates(locationViewModel)

            } else{
                val rationalRequired = ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ) || ActivityCompat.shouldShowRequestPermissionRationale(
                    context,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                )

                if(rationalRequired){
                    Toast.makeText(context, "Location is required for this feature to work!", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context, "Location permission is required for this feature to work please enable it in the settings!", Toast.LENGTH_LONG).show()

                }
            }
        })

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){

        if(locationData == null){
            Text(text = "Location Not Available")
        }else{
            Text(text = "Longitude ${locationData.longitude}, Latitude: ${locationData.latitude}")
        }

        Button(
            modifier = Modifier.padding(8.dp),
            onClick = {
                if (locationUtils.hasPermission(context)){
                    locationUtils.requestLocationUpdates(locationViewModel)
                    //Toast.makeText(context, "You have permission", Toast.LENGTH_LONG).show()
                }else{
                    //Toast.makeText(context, "You need permission", Toast.LENGTH_LONG).show()
                    requestActivityLauncher.launch(
                        arrayOf(
                            android.Manifest.permission.ACCESS_FINE_LOCATION,
                            android.Manifest.permission.ACCESS_FINE_LOCATION,
                        )
                    )
                }
            }
        ) {
            Text(text = "Check Now")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LocationAppTheme {
        //LocationUI()
    }
}