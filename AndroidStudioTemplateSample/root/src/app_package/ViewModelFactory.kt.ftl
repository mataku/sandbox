package ${packageName}

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ${className}Factory: ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(${className}::class.java)) {
            return ${className}() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
