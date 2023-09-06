package com.example.newsappcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappcompose.domain.usecases.app_entry.ReadAppEntry
import com.example.newsappcompose.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val readAppEntry: ReadAppEntry
) : ViewModel() {

    var splashCondition by mutableStateOf(true)


    var startDestination by mutableStateOf(Route.AppStartNavigation.route)


    init {
        readAppEntry().onEach { shouldStartFromHomeScreen ->
            if (shouldStartFromHomeScreen) {
                startDestination = Route.NewsNavigation.route
            } else {
                startDestination = Route.AppStartNavigation.route
            }

            delay(300)
            splashCondition = false

        }.launchIn(viewModelScope)
    }
}