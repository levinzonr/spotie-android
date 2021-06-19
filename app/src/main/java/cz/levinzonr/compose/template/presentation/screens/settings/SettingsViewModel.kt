package cz.levinzonr.compose.template.presentation.screens.settings

import androidx.lifecycle.ViewModel
import cz.levinzonr.compose.template.domain.usecases.GetModelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val getModelUseCase: GetModelUseCase
) : ViewModel()
