package ${packageName}

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ${className}: ViewModel() {
    data class UiModel(val error: Throwable?)

    private val _liveData = MutableLiveData<UiModel>()
    val liveData: LiveData<UiModel>
        get() = _liveData

    fun method() {
        viewModelScope.launch {
        }
    }
}
