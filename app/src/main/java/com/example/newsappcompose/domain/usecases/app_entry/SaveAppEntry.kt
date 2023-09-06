package com.example.newsappcompose.domain.usecases.app_entry

import android.util.Log
import com.example.newsappcompose.domain.manager.LocalUserManager
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}