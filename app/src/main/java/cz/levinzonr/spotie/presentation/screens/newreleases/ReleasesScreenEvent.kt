package cz.levinzonr.spotie.presentation.screens.newreleases

import cz.levinzonr.spotie.domain.models.NewRelease

sealed interface ReleasesScreenEvent {
    data class AddToLibrary(val release: NewRelease): ReleasesScreenEvent
    data class ReleaseClick(val release: NewRelease): ReleasesScreenEvent
}