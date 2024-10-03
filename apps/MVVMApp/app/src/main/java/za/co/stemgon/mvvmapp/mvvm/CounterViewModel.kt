package za.co.stemgon.mvvmapp.mvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import java.io.Closeable

class CounterViewModel: ViewModel() {
    private val _count = mutableIntStateOf(0)


    override fun addCloseable(closeable: Closeable) {
        super.addCloseable(closeable)
    }

    public val count: MutableState<Int> = _count

    fun Decrement(){
        _count.value--
    }
    fun Increment(){
        _count.value++
    }
}