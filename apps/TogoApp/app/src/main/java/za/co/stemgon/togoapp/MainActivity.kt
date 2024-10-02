package za.co.stemgon.togoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import za.co.stemgon.togoapp.ui.theme.TogoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TogoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodoListApp()
                }
            }
        }
    }
}

@Composable
fun TodoListApp(){
    Column( horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Add Todo")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "List of your todos", Modifier.padding(8.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.padding(8.dp))
        Row(  modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Cancel")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Add Todo")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoListAppPreview() {
    TogoAppTheme {
        TodoListApp()
    }
}