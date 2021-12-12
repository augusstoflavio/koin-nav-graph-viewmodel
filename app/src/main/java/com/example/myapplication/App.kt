package com.example.myapplication

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        val mainModule = module {
            viewModel {
                FormViewModel()
            }
        }

        startKoin {
            androidContext(this@App)
            modules(
                mainModule
            )
        }
    }
}