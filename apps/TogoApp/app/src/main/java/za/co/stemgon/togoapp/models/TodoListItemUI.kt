package za.co.stemgon.togoapp.models
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.unit.dp

@Composable
fun TodoListItem(
    item: Todo,
    onEditClick: ()  -> Unit,
    onDeleteClick: ()  -> Unit,

){
    Row( modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .border(BorderStroke(2.dp, Color.Cyan), shape = RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(modifier = Modifier.padding(16.dp), text = item.name)
        Spacer(modifier = Modifier.width(8.dp))
        Text("Qty: ${ item.numberOfItems }")

        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = onDeleteClick ) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "${ item.name}")
        }

        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = onEditClick ) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "${ item.name}")
        }


    }
}