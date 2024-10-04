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
    private val makeState: State<MakeState> = _makeState

    private fun fetchMakes(){
        viewModelScope.launch {
            try {
                val  response = makeAPIService.getMakes()
                _makeState.value = _makeState.value.copy(
                    isLoading = false,
                    error = null,
                    list = response.result
                )

            }catch (e: Exception){
                _makeState.value = _makeState.value.copy(
                    isLoading = false,
                    error = "Error feching makes ${e.message}",
                    list = emptyList()
                )
            }
        }
    }

    data class MakeState(
        var isLoading: Boolean = true,
        var list: List<Make> = emptyList(),
        var error: String? = null
    )
}