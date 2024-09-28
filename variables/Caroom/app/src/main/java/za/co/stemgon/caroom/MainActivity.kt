package za.co.stemgon.caroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        }
    }
}


@Composable
fun UnitConvertor(){
    Column {
        Text(text = "Unit Convertor")
        OutlinedTextField(value = "", onValueChange = {})
        Row {
            Column {

                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {

                }
            }
            
            Column {

                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {

                }
            }
        }

        Text(text = "5 m: 500cm")
    }
}