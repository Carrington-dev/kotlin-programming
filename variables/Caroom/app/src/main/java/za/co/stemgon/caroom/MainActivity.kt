package za.co.stemgon.caroom

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun CurrencyConvertor() {
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
fun UnitConvertor() {
    var inputValue by remember {
        mutableStateOf("1")
    }
    var iXpanded by remember {
        mutableStateOf(false)
    }
    var oXpanded by remember {
        mutableStateOf(false)
    }
    var computedValue by remember {
        mutableStateOf(0.00)
    }
    var multiplier by remember {
        mutableStateOf(0.01)
    }

    var outputUnit by remember {
        mutableStateOf("m")
    }

    var inputUnit by remember {
        mutableStateOf("cm")
    }

    fun convertUnits(){
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        var outputValueDouble = inputValueDouble * multiplier
        computedValue =  outputValueDouble
    }

    fun calculateMultiplier(): Double{
        if(outputUnit == "m" && inputUnit == "cm"){
            multiplier = 0.01
        }else if(outputUnit == "cm" && inputUnit == "m"){
            multiplier = 100.00
        }else if(outputUnit == "km" && inputUnit == "m"){
            multiplier = 1000.00
        }else if(outputUnit == "m" && inputUnit == "km"){
            multiplier = 0.001
        }else if((outputUnit == "mm") && (inputUnit == "cm")){
            multiplier = 10.0
        }else if(outputUnit == "cm" && inputUnit == "mm"){
            multiplier = 0.1
        }else if(outputUnit == "mm" && inputUnit == "m"){
            multiplier = 1000.00
        }else if(outputUnit == "m" && inputUnit == "mm"){
            multiplier = 0.001
        }

        return multiplier
    }



    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Unit Convertor")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
        })
        Spacer(modifier = Modifier.height(16.dp))
        Row {

            val context = LocalContext.current
            Box {
                Button(onClick = { /*TODO*/
                    // Input
                    iXpanded = true
                }) {
                    Text(text = "Select ")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
                DropdownMenu(expanded = iXpanded, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(
                        text = { /*TODO*/
                            Text(text = "Centimeters")
                        },
                        onClick = { /*TODO*/
                            iXpanded = false
                            inputUnit = "cm"
                            calculateMultiplier()
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { /*TODO*/
                            Text(text = "Kilometers")
                        },
                        onClick = { /*TODO*/
                            iXpanded = false
                            inputUnit = "km"
                            calculateMultiplier()
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { /*TODO*/
                            Text(text = "Meters")
                        },
                        onClick = { /*TODO*/
                            iXpanded = false
                            inputUnit = "m"
                            calculateMultiplier()
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { /*TODO*/
                            Text(text = "Millimeters")
                        },
                        onClick = { /*TODO*/
                            iXpanded = false
                            inputUnit = "mm"
                            calculateMultiplier()
                            convertUnits()
                        }
                    )

                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Box {
                Button(onClick = { /*TODO*/
                    oXpanded = true
                }) {
                    Text(text = "Select ")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
                DropdownMenu(expanded = oXpanded, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(
                        text = { /*TODO*/
                            Text(text = "Centimeters")
                        },
                        onClick = { /*TODO*/
                            oXpanded = false
                            outputUnit = "cm"
                            multiplier = calculateMultiplier()
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { /*TODO*/
                            Text(text = "Kilometers")
                        },
                        onClick = { /*TODO*/
                            oXpanded = false
                            outputUnit = "km"
                            calculateMultiplier()
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { /*TODO*/
                            Text(text = "Meters")
                        },
                        onClick = { /*TODO*/
                            oXpanded = false
                            outputUnit = "m"
                            calculateMultiplier()
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { /*TODO*/
                            Text(text = "Millimeters")
                        },
                        onClick = { /*TODO*/
                            oXpanded = false
                            outputUnit = "mm"
                            calculateMultiplier()
                            convertUnits()
                        }
                    )

                }

            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Result: $inputValue $inputUnit equates to $computedValue $outputUnit")


//        Button(onClick = { /*TODO*/
//
//
//        }) {
//            Text(text = "Click Me!")
//        }
    }
}