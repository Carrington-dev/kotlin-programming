package za.co.stemgon.mvvmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import za.co.stemgon.mvvmapp.mvvm.CounterViewModel
import za.co.stemgon.mvvmapp.ui.theme.MVVMAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: CounterViewModel = CounterViewModel()
        setContent {
            MVVMAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OldMethodUI(viewModel)
                }
            }
        }
    }
}

@Composable
fun OldMethodUI(viewModel: CounterViewModel){
//    var counter by remember {
//        mutableIntStateOf(0)
//    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Counter: ${viewModel.count.value}",
            modifier = Modifier.padding(32.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
            ) {
            Button(onClick = { viewModel.Decrement() }) {
                Text(text = "Decrement")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { viewModel.Increment() }) {
                Text(text = "Increment")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OldMethodUIPreview() {
    MVVMAppTheme {
//        OldMethodUI(V)
    }
}