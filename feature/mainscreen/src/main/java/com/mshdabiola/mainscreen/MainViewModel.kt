package com.mshdabiola.mainscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.mshdabiola.data.repository.ModelRepository
import com.mshdabiola.model.Model
import com.mshdabiola.ui.data.Notify
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val modelRepository: ModelRepository,
) : ViewModel() {

    val modelState = modelRepository
        .getModelPaging()
        .map { it.map { it.asModelUiState() } }
        .cachedIn(viewModelScope)
//        .asResult()
//        .stateIn(scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(3000), initialValue = MainState.Loading)


    private val _mainState = MutableStateFlow(MainState())
    val mainState = _mainState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2000)
            addNotify("Add Model")
            addNotify("remove model")
        }

    }

    fun addName(name: String) {
        insert(Model(name = name))
    }

    fun insert(model: Model) {
        viewModelScope.launch(Dispatchers.IO) {
            modelRepository.insertModel(model)
        }
    }

    private fun addNotify(text: String) {
        Timber.d("Add")
        val notifies = mainState.value.messages.toMutableList()

        notifies.add(Notify(message = text, callback = ::onNotifyDelive))
        _mainState.update {
            it.copy(messages = notifies.toImmutableList())
        }
    }

    private fun onNotifyDelive() {
        Timber.d("Remove")
        val notifies = mainState.value.messages.toMutableList()

        notifies.removeFirst()
        _mainState.value = mainState.value.copy(messages = notifies.toImmutableList())
    }

}
