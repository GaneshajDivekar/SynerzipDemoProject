package com.demoproject.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.demoproject.R
import com.demoproject.database.MyRoomDataBase
import com.demoproject.databinding.ActivityHomeBinding
import com.demoproject.model.HomeScreenDB
import com.demoproject.ui.activity.interfaces.ItemClick
import com.demoproject.ui.activity.adapter.GridAdapter
import com.demoproject.ui.base.BaseActivity
import com.demoproject.viewmodel.HomeViewModel
import java.util.ArrayList

class HomeActivity : BaseActivity<HomeViewModel>(), ItemClick {
    private lateinit var activityHomeActivity: ActivityHomeBinding
    var gridAdapter : GridAdapter?=null
    var getAllHome=ArrayList<HomeScreenDB>()
    var itemClick: ItemClick? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeActivity = DataBindingUtil.setContentView(this,R.layout.activity_home)
        activityHomeActivity.viewModel = viewModel
        activityHomeActivity.lifecycleOwner = this
        itemClick=this
        getAllHome = MyRoomDataBase.getInstance(this).getNoteDao().loadAllHome() as ArrayList<HomeScreenDB>
        gridAdapter=GridAdapter(this,getAllHome, itemClick)
        activityHomeActivity!!.grView.setLayoutManager(GridLayoutManager(this,2))
        activityHomeActivity.grView.setAdapter(gridAdapter)
    }

    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun onClick(pos: Int) {
        var intent = Intent(this, PlannedActivity::class.java)
        startActivity(intent)
    }
}