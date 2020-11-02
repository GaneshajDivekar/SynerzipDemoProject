package com.demoproject.ui.activity


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.demoproject.R
import com.demoproject.ui.base.BaseActivity
import com.demoproject.ui.fragment.HomeFragment
import com.demoproject.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel>() {
    private lateinit var mView: View
    private val homeFragment = HomeFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeFragments()
    }

    fun initializeFragments() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, homeFragment)
        fragmentTransaction.commit()
    }
    fun addFragmentWithBackStack(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout, fragment, fragment.javaClass.simpleName)
            .addToBackStack(null)
            .commit()
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

}
