package za.co.stemgon.togoapp.models
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
        .border(BorderStroke(2.dp, Color.Cyan))){
        Text(modifier = Modifier.padding(16.dp), text = item.name)
        Spacer(modifier = Modifier.width(8.dp))
    }
}