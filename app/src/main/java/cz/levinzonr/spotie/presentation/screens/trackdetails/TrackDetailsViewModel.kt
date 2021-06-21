package cz.levinzonr.spotie.presentation.screens.trackdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.levinzonr.spotie.presentation.screens.trackdetails.args.TrackDetailsRouteArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val state = MutableStateFlow("")
    init {
        viewModelScope.launch {
            val args = TrackDetailsRouteArgs.fromSavedStatedHandle(savedStateHandle)
            state.value = args.toString()
        }
    }
}
