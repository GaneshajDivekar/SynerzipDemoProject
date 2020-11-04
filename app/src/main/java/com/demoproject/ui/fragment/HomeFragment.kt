package com.demoproject.ui.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView.OnEditorActionListener
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.demoproject.R
import com.demoproject.database.MyRoomDataBase
import com.demoproject.databinding.FragmentHomeLayoutBinding
import com.demoproject.ui.activity.HomeActivity
import com.demoproject.ui.activity.MainActivity
import com.demoproject.ui.activity.PlannedDetailsActivity
import com.demoproject.ui.base.BaseFragment
import com.demoproject.utils.AppConstant
import com.demoproject.utils.PrefUtils
import com.demoproject.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_home_layout.*
import java.text.DateFormat
import java.util.*


class HomeFragment : BaseFragment<MainViewModel>() {

    val TAG = HomeFragment::class.java.simpleName
    private lateinit var binding: FragmentHomeLayoutBinding
    private var progressView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_layout, null, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.imageView3.setOnClickListener {
            val fragment: Fragment = LoginFragment()
                (activity as MainActivity).addFragmentWithBackStack(fragment)
        }
      /*  var intent= Intent(activity, HomeActivity::class.java)
        startActivity(intent)*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchEditText.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (AppConstant.iSflusheRequire(activity!!.applicationContext)) {
                    MyRoomDataBase.getInstance(activity!!.applicationContext).getNoteDao().delete()
                    PrefUtils.saveToPrefs(
                        activity,
                        PrefUtils.TIMESTAMP,
                        "" + System.currentTimeMillis()
                    )
                    searchPeform()
                } else {
                    searchPeform()
                }
                return@OnEditorActionListener true
            }
            false
        })

        searchEditText.setOnClickListener {
            searchPeform()
        }

        search_button.setOnClickListener {
            if (AppConstant.iSflusheRequire(activity!!.applicationContext)) {
                MyRoomDataBase.getInstance(activity!!.applicationContext).getNoteDao().delete()
                PrefUtils.saveToPrefs(
                    activity,
                    PrefUtils.TIMESTAMP,
                    "" + System.currentTimeMillis()
                )
                searchPeform()
            } else {
                searchPeform()
            }
        }
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    private fun searchPeform() {
        var city = searchEditText.text.toString()
        progressView=showProgressBar()
        viewModel.getWeatherData(city)
            .observe(viewLifecycleOwner, Observer {
                try {
                    val df: DateFormat = DateFormat.getDateInstance(DateFormat.FULL)
                    val updatedOn: String = df.format(Date(it?.dt!!.toLong() * 1000))
                    val str2: List<String> = updatedOn.split(",")
                    val str3 = str2[0] //goodmorning
                    val str4 = str2[1]
                    binding.constraintLayout6.visibility = View.VISIBLE
                    binding?.txtDate?.setText("" + str4)
                    binding?.textView15?.setText("" + str3)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                binding.data = it
                progressView?.let { cancelProgressBar(it) }
            })
    }

}