package za.co.stemgon.togoapp

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import za.co.stemgon.togoapp.models.Todo
import za.co.stemgon.togoapp.models.TodoListItem
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
fun MainAppUI(){
    var isDialogOpen by remember {
        mutableStateOf(false)
    }
    var nameOfTodoItem by remember {
        mutableStateOf("")
    }
    var numberOfTodoItems by remember {
        mutableStateOf("1")
    }
    var todoItems by remember {
        mutableStateOf(listOf<Todo>(
            Todo(1, "Cooking", 2),
            Todo(2, "Baking", 52),
            Todo(3, "Bathing", 5),
        ))
    }
    Button(onClick = { isDialogOpen = true }) {
        Text(text = "Add Todo")

    }
    LazyColumn(content = {
        items(todoItems){
            val context = LocalContext.current
            TodoListItem(
                item = it,
                onEditClick = {

                    Toast.makeText(context, "Edited item ${it.name}", Toast.LENGTH_SHORT ).show()
                },
                onDeleteClick = {
                    Toast.makeText(context, "Deleted item ${it.name}", Toast.LENGTH_SHORT ).show()
                }
            )

        }
    })
    Spacer(modifier = Modifier.height(8.dp))
    if( isDialogOpen ){
        AlertDialog(
            onDismissRequest = {
                    isDialogOpen = false
            },
            confirmButton = {
                var context = LocalContext.current
                Button(onClick = { /*TODO*/
                    isDialogOpen = false
                    //todoItems = todoItems(Todo(todoItems.size+1, nameOfTodoItem, numberOfTodoItems.toIntOrNull() ?: 1))
                    Toast.makeText(context, "Added a new items, ow have ${todoItems.size}", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Add")
                }
            },
            title = {
                Column {
                Text(text = "List of your todos", Modifier.padding(8.dp))
                OutlinedTextField(value = nameOfTodoItem, onValueChange = { nameOfTodoItem = it}, modifier = Modifier.padding(8.dp))
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = numberOfTodoItems, onValueChange = { numberOfTodoItems = it}, modifier = Modifier.padding(8.dp))
                Row(  modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){



                }
            }
            }
        )
    }

}

@Composable
fun TodoListApp(){

    Column( horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        MainAppUI()
    }
}



@Preview(showBackground = true)
@Composable
fun TodoListAppPreview() {
    TogoAppTheme {
        TodoListApp()
    }
}