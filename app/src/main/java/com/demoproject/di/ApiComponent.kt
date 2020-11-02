package com.demoproject.di

import com.demoproject.repository.PlannedDetailsRepo
import com.demoproject.ui.activity.HomeActivity
import com.demoproject.ui.activity.MainActivity
import com.demoproject.ui.activity.PlannedActivity
import com.demoproject.ui.activity.PlannedDetailsActivity
import com.demoproject.viewmodel.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class])
interface ApiComponent {
    fun inject(loginViewModel: LoginViewModel)
    fun inject(mainViewModel: MainViewModel)
    fun inject(mainActivity: MainActivity)
    fun inject(homeActivity: HomeActivity)
    fun inject(homeViewModel: HomeViewModel)
    fun inject(plannedActivity: PlannedActivity)
    fun inject(plannedViewModel: PlannedViewModel)
    fun inject(plannedDetailsActivity: PlannedDetailsActivity)
    fun inject(plannedDetailsViewModel: PlannedDetailsViewModel)
    fun inject(pendingViewModel: PendingViewModel)

}