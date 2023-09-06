package com.example.newsappcompose.presentation.onboarding

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappcompose.domain.usecases.app_entry.SaveAppEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val saveAppEntry: SaveAppEntry) :
    ViewModel() {


    fun onEvent(event: OnBoardingEvent) {
        when (event) {
            is OnBoardingEvent.SavedAppEntry -> {
                viewModelScope.launch {
                    saveAppEntry()
                }
            }
        }
    }


}