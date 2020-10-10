package com.demoproject.ui.base

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.demoproject.R

abstract class BaseFragment<V : BaseViewModel> : Fragment() {

    protected lateinit var viewModel: V

    abstract fun getViewModel(): Class<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelProvider.AndroidViewModelFactory(activity!!.application)
        ).get(getViewModel())
    }

    protected fun finish() {
        activity?.finish()
    }


    private lateinit var viewGroup: ViewGroup
    open fun isOnline(context: Context): Boolean {
        val cm =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

    open fun showProgressBar(): View {
        viewGroup = activity!!.findViewById(android.R.id.content)
        val view: View =
            LayoutInflater.from(activity).inflate(R.layout.progress_layout, null)
        viewGroup.addView(view)
        return view
    }

    open fun cancelProgressBar(view: View) {
        if (view != null) {
            viewGroup.removeView(view)
        }
    }


}