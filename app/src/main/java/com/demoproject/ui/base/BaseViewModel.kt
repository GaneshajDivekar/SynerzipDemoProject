package com.demoproject.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.demoproject.repository.PlannedDetailsRepo

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    protected val context = getApplication<Application>().applicationContext
}