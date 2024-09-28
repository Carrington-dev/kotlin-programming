package za.co.stemgon.caroom

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import za.co.stemgon.caroom.ui.theme.CaroomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaroomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Maám")
                    UnitConvertor()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CaroomTheme {
//        Greeting("Maám")
        UnitConvertor()
    }

}


@Composable
fun CurrencyConvertor(){
    Column {
        Greeting(name = "Carrington")
        Greeting(name = "Carrington")
        Greeting(name = "Carrington")
        Row {
            Greeting(name = "Muleya")
            Greeting(name = "Muleya")
            Greeting(name = "Muleya")
            val context = LocalContext.current
            Button(onClick = { /*TODO*/

                Toast.makeText(context, "Hi there I was clicked", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Click Me!")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Click Me!")
            }
        }
    }
}


@Composable
fun UnitConvertor(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Unit Convertor")
        OutlinedTextField(value = "", onValueChange = {})
        Row {

            val context = LocalContext.current
            Box{
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Select Options")
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                    }
            }
        }

        Text(text = "Result: 500cm")


//        Button(onClick = { /*TODO*/
//
//
//        }) {
//            Text(text = "Click Me!")
//        }
    }
}