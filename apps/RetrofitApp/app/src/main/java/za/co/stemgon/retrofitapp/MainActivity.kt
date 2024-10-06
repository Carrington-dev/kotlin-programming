package za.co.stemgon.retrofitapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import za.co.stemgon.retrofitapp.models.Make
import za.co.stemgon.retrofitapp.models.MakeItem
import za.co.stemgon.retrofitapp.models.MakeItemLayout
import za.co.stemgon.retrofitapp.ui.theme.RetrofitAppTheme
import za.co.stemgon.retrofitapp.viewmodel.MakeViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var makeViewModel = ViewModelProvider(this).get(MakeViewModel::class.java)

                    APIAppUI()
                }
            }
        }
    }
}

@Composable
fun APIAppUI() {


    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        MakeItemLayout()
        //Text(text = "Welcome")
        //MakeItem(Make("id", "Make", 3, "image", "image"))

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitAppTheme {
        APIAppUI()
    }
}