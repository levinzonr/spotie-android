package cz.levinzonr.spotie.presentation.screens.settings

import androidx.lifecycle.ViewModel
import cz.levinzonr.spotie.domain.usecases.GetModelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val getModelUseCase: GetModelUseCase
) : ViewModel()
