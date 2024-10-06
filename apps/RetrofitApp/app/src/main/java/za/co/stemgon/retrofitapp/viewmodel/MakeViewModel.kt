package za.co.stemgon.retrofitapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import za.co.stemgon.retrofitapp.models.Make
import za.co.stemgon.retrofitapp.services.makeAPIService

class MakeViewModel: ViewModel() {

    init {
        fetchMakes()
    }

    private  val _makeState = mutableStateOf(MakeState())
    val makeState: State<MakeState> = _makeState

    private fun fetchMakes(){
        viewModelScope.launch {
            try {
                println("Before requesting from API: isLoading: true")

                val  response = makeAPIService.getMakes()
                _makeState.value = _makeState.value.copy(
                    isLoading = false,
                    error = null,
                    list = response.results,
                )

                println(response)



            }catch (e: Exception){

                _makeState.value = _makeState.value.copy(
                    isLoading = false,
                    error = "Error fetching makes ${e.message}",
                    list = emptyList()
                )
                println("An error has occurred: ${e.message}")
            }finally {
                //println("Categories ->")
                //println(makeState.value.list)
                //println("IsLoading ->")
                println("After requesting from API")
                println("IsLoading: -> ${makeState.value.isLoading}, size: ${makeState.value.list.size}")
            }


        }
    }

    data class MakeState(
        var isLoading: Boolean = true,
        var list: List<Make> = emptyList(),
        var error: String? = null
    )
}


