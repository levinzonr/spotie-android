package cz.levinzonr.spotie.presentation.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.levinzonr.spotie.presentation.screens.details.args.DetailsRouteArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val state = MutableStateFlow("")
    init {
        viewModelScope.launch {
            val args = DetailsRouteArgs.fromSavedStatedHandle(savedStateHandle)
            state.value = args.toString()
        }
    }
}
