package com.ismailcanvarli.moviebank.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Uygulama sınıfı. Hilt bağımlılık enjeksiyonu için gerekli olan temel yapılandırmayı sağlar.
 */
@HiltAndroidApp
class MovieBankApp : Application()