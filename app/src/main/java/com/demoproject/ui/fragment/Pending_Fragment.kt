package com.demoproject.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.demoproject.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.demoproject.database.MyRoomDataBase
import com.demoproject.databinding.FragmentPendingBinding
import com.demoproject.model.VisitDB
import com.demoproject.ui.activity.PlannedActivity
import com.demoproject.ui.activity.PlannedDetailsActivity
import com.demoproject.ui.activity.adapter.VisitAdapter
import com.demoproject.ui.activity.interfaces.ItemClick
import com.demoproject.ui.base.BaseFragment
import com.demoproject.viewmodel.PendingViewModel
import java.util.ArrayList

class Pending_Fragment : BaseFragment<PendingViewModel>(),ItemClick {

    private lateinit var pendingFragmentPendingBinding: FragmentPendingBinding
    var visitAdapter:VisitAdapter?=null
    var itemClick:ItemClick?=null
    var displayData=ArrayList<VisitDB>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        pendingFragmentPendingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_pending_, container, false)
        pendingFragmentPendingBinding.viewModel = viewModel
        pendingFragmentPendingBinding.lifecycleOwner = this
        itemClick=this
        displayData = MyRoomDataBase.getInstance(this!!.activity!!).getNoteDao().loadAllVisit("0") as ArrayList<VisitDB>
        visitAdapter= VisitAdapter(requireActivity(), displayData,itemClick as Pending_Fragment)
        pendingFragmentPendingBinding!!.rcPView.setLayoutManager(LinearLayoutManager(activity))
        pendingFragmentPendingBinding.rcPView.setAdapter(visitAdapter)
        return pendingFragmentPendingBinding.root
    }

    override fun getViewModel(): Class<PendingViewModel> {
        return PendingViewModel::class.java
    }

    override fun onClick(pos: Int) {
        var intent= Intent(activity, PlannedDetailsActivity::class.java)
        intent.putExtra("abc",displayData.get(pos).visitCategoryCode)
        startActivity(intent)
    }
}

