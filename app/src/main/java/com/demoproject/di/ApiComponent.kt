package com.demoproject.di

import com.demoproject.ui.activity.MainActivity
import com.demoproject.viewmodel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class])
interface ApiComponent {
    fun inject(mainViewModel: MainViewModel)
    fun inject(mainActivity: MainActivity)
}