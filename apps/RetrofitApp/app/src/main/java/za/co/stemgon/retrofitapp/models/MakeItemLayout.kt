package za.co.stemgon.retrofitapp.models

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import za.co.stemgon.retrofitapp.viewmodel.MakeViewModel

@Composable
fun MakeItemLayout(modifier: Modifier = Modifier){
    // val context =  LocalContext.current
    // val makeViewModel: MakeViewModel = MakeViewModel()
    val makeViewModel: MakeViewModel = viewModel()
    val viewState by makeViewModel.makeState

    println("isLoading: ${viewState.isLoading} ")
    println(viewState.list)
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // In Fragment or Activity


        when{
            viewState.isLoading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                // Text(text = "An error has occurred!")
                Toast.makeText(LocalContext.current,
                    "An error has occurred!", Toast.LENGTH_SHORT).show()
            }

            else -> {
                MakeScreen(makes = viewState.list)
            }
        }

    }
}

@Composable
fun MakeScreen(makes: List<Make> ){
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()){
        items( makes ){
            make ->
            MakeItem(make = make)
        }
    }
}

@Composable
fun MakeItem(make: Make){
    val painter: Painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(make.image)
            .crossfade(true)
            .size(Size.ORIGINAL)
            .build()
    )
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Image(
//            painter = painter,
//            contentDescription = make.name,
//            modifier = Modifier.size(200.dp),
//
//        )

        LoadSvgImage("https://api.vroomhive.co.za/media/vehicle/car.jpg")
//        Image(
//            painter = rememberAsyncImagePainter(model = make.image),
//            contentDescription = make.name,
//            modifier = Modifier
//                .fillMaxSize()
//                .aspectRatio(1f))

        Text(
            text = "${make.name}",
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top=4.dp)
        )
        //Text(text = "${make.name}", color = Color.Black)
        Text(text = "${make.vehicle_count}", color = Color.Black)
    }

}


@Composable
fun LoadSvgImage(url: String) {
    val painter: Painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .size(Size.ORIGINAL)
            .build()
    )

    Box(modifier = Modifier.size(200.dp)) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
    }
}