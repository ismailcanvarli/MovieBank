//Created by canVarli on 1/20/2025

package com.ismailcanvarli.moviebank.ui.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ismailcanvarli.moviebank.R

/**
 * Uygulamanın başlangıç ekranı. Uygulama açıldığında gösterilir.
 *
 * @param navigateToHome Ana ekrana geçiş yapılacak fonksiyon.
 * @param viewModel Splash ekranı için kullanılan ViewModel.
 */
@Composable
fun SplashScreen(
    navigateToHome: () -> Unit,
    viewModel: SplashViewModel = viewModel()
) {
    val isSplashFinished = viewModel.isSplashFinished.collectAsState()

    if (isSplashFinished.value) {
        LaunchedEffect(Unit) {
            navigateToHome()
        }
    } else {
        val composition =
            rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash_animation))
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            LottieAnimation(composition.value)
        }
    }
}