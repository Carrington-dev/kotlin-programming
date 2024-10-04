package za.co.stemgon.retrofitapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import za.co.stemgon.retrofitapp.viewmodel.MakeViewModel

@Composable
fun MakeItemLayout(modifier: Modifier = Modifier){
    val makeViewModel: MakeViewModel = MakeViewModel()
    val viewState = makeViewModel.makeState

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        when{
            viewState.value.isLoading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewState.value.error != null -> {
                Text(text = "An error has occurred!")
            }
            else -> {

            }
        }
    }
}