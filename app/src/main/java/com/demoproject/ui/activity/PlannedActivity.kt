package com.demoproject.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.demoproject.R
import com.demoproject.databinding.ActivityPlannedBinding
import com.demoproject.model.VisitDB
import com.demoproject.ui.activity.adapter.MyAdapter
import com.demoproject.ui.activity.adapter.ViewPagerAdapter
import com.demoproject.ui.activity.adapter.VisitAdapter
import com.demoproject.ui.activity.interfaces.ItemClick
import com.demoproject.ui.base.BaseActivity
import com.demoproject.ui.fragment.CompletedFragment
import com.demoproject.ui.fragment.Pending_Fragment
import com.demoproject.viewmodel.PlannedViewModel
import com.google.android.material.tabs.TabLayout
import java.util.*

class PlannedActivity : BaseActivity<PlannedViewModel>(),ItemClick {
    private lateinit var activityPlannedBinding: ActivityPlannedBinding
    var getAllVisit=ArrayList<VisitDB>()
    var visitAdapter:VisitAdapter?=null
    private var itemClick:ItemClick?=null
    var viewPager:ViewPager?=null
    var tabLayout:TabLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPlannedBinding = DataBindingUtil.setContentView(this,R.layout.activity_planned)
        activityPlannedBinding.viewModel = viewModel
        activityPlannedBinding.lifecycleOwner = this
        itemClick=this
        setupViewPager(activityPlannedBinding.viewPager)
        activityPlannedBinding.tabLayout.setupWithViewPager(activityPlannedBinding.viewPager);
    }
    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Pending_Fragment(), getString(R.string.pendings).toUpperCase())
        adapter.addFragment(CompletedFragment(), getString(R.string.complete).toUpperCase())
        viewPager.adapter = adapter
    }
    override fun getViewModel(): Class<PlannedViewModel> {
        return PlannedViewModel::class.java
    }

    override fun onClick(pos: Int) {
        var intent=Intent(this,PlannedDetailsActivity::class.java)
        intent.putExtra("abc",getAllVisit.get(pos).visitCategoryCode)
        startActivity(intent)
    }
}