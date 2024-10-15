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
import za.co.stemgon.locationapp.ui.theme.LocationAppTheme
import za.co.stemgon.locationapp.utils.LocationUtils

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //
                    LocationUI()
                }
            }
        }
    }
}

@Composable
fun LocationUI(){
    val context = LocalContext.current
    val locationUtils: LocationUtils = LocationUtils(context)

    val requestActivityLauncher =  rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = {
            permissions ->
            if (permissions[android.Manifest.permission.ACCESS_COARSE_LOCATION] == true
                && permissions[android.Manifest.permission.ACCESS_FINE_LOCATION] == true){

            }
            else{

            }
        })

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Button(
            modifier = Modifier.padding(8.dp),
            onClick = {
                if (locationUtils.hasPermission(context)){
                    Toast.makeText(context, "You have permission", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context, "You need permission", Toast.LENGTH_LONG).show()

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
        LocationUI()
    }
}