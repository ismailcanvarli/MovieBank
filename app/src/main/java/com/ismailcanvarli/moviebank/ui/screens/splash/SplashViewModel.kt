//Created by canVarli on 1/20/2025

package com.ismailcanvarli.moviebank.ui.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Uygulamanın başlangıç ekranı için ViewModel sınıfı.
 */
class SplashViewModel : ViewModel() {
    private val _isSplashFinished = MutableStateFlow(false)
    val isSplashFinished: StateFlow<Boolean> = _isSplashFinished

    init {
        startSplashTimer()
    }

    /**
     * Splash ekranı için bir süre belirler ve süre sonunda splash ekranını kapatır.
     */
    private fun startSplashTimer() {
        viewModelScope.launch {
            delay(3000)
            _isSplashFinished.value = true
        }
    }
}