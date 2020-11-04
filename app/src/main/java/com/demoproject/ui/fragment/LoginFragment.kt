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
import com.demoproject.database.MyRoomDataBase
import com.demoproject.databinding.FragmentLoginBinding
import com.demoproject.model.AllTravelModeDB
import com.demoproject.model.AllTravelTypeDB
import com.demoproject.model.HomeScreenDB
import com.demoproject.model.VisitDB
import com.demoproject.ui.activity.HomeActivity
import com.demoproject.ui.base.BaseFragment
import com.demoproject.utils.SessionManger
import com.demoproject.utils.SessionManger.Companion.PREF_FILE_NAME
import com.demoproject.viewmodel.LoginViewModel


class LoginFragment : BaseFragment<LoginViewModel>() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var sessionManger: SessionManger
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sessionManger = activity?.let { SessionManger(it, PREF_FILE_NAME) }!!

        binding.button.setOnClickListener {
            var username = binding.editTextTextPersonName.text.toString().trim()
            var password = binding.editTextTextPassword.text.toString().trim()
            if (username.equals("")) {
                Toast.makeText(activity, "username", Toast.LENGTH_SHORT).show()
            } else if (password.equals("")) {
                Toast.makeText(activity, "password", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.validateLogin(username, password, "", "", "", "", "", "", "", "", "0")
                    .observe(viewLifecycleOwner, Observer {
                        if (it != null) {
                            MyRoomDataBase.getInstance(activity!!).getNoteDao().deleteHome()
                            MyRoomDataBase.getInstance(activity!!).getNoteDao().deleteVisit()

                            var userID = it.data?.userId?.toInt()
                            sessionManger.setUserID(userID?.toInt()!!)
                            sessionManger.setCompanyId(it.data!!.businessUnits!!.get(0).businessUnitId!!.toInt())
                            viewModel.getHomeScreen(
                                it.data?.userId.toString(),
                                it.data?.businessUnits?.get(0)?.businessUnitId.toString()
                            )
                                .observe(viewLifecycleOwner, Observer {
                                    if (it != null) {
                                        for (item in it.data!!.homescreenlist!!.indices) {
                                            var homeScreenDB = HomeScreenDB()
                                            homeScreenDB.app_menu_desc =
                                                it.data!!.homescreenlist?.get(item)?.appMenuDesc
                                            homeScreenDB.app_menu_code =
                                                it.data!!.homescreenlist?.get(item)?.appMenuCode
                                            homeScreenDB.app_menu_id =
                                                it.data!!.homescreenlist?.get(item)?.appMenuId.toString()
                                            homeScreenDB.pending_item_count =
                                                it.data!!.homescreenlist?.get(item)?.pendingItemCount.toString()
                                            MyRoomDataBase.getInstance(this!!.activity!!)
                                                .getNoteDao()!!
                                                .insertHome(homeScreenDB)
                                        }
                                        viewModel.getAllVisit(
                                            sessionManger.getUserID(),
                                            sessionManger.getCompanyId()
                                        )
                                            .observe(viewLifecycleOwner, Observer {
                                                if (it != null) {
                                                    for (i in it.data!!.indices) {
                                                        var visitDB = VisitDB()
                                                        visitDB.visit_type_desc =
                                                            it.data!!.get(i).visit_type_desc
                                                        visitDB.visitCategoryCode =
                                                            it.data!!.get(i).visitCategoryCode
                                                        visitDB.bank_desc =
                                                            it.data!!.get(i).bank_desc
                                                        visitDB.callStatus =
                                                            it.data!!.get(i).callStatus
                                                        visitDB.siteAddress =
                                                            it.data!!.get(i).siteAddress
                                                        visitDB.ticketNo = it.data!!.get(i).ticketNo
                                                        visitDB.online = "0"
                                                        MyRoomDataBase.getInstance(activity!!)
                                                            .getNoteDao().insertVisit(visitDB)
                                                    }

                                                    viewModel.getAllTravelTypes(sessionManger.getUserID())
                                                        .observe(viewLifecycleOwner, Observer {
                                                            if (it != null) {
                                                                for (i in it.data.indices) {
                                                                    var allTravelTypeDB =AllTravelTypeDB()
                                                                    allTravelTypeDB.active = it.data.get(i).isActive.toString()
                                                                    allTravelTypeDB.typeTravelDescriptions=it.data.get(i).typeTravelDescription
                                                                    MyRoomDataBase.getInstance(activity!!).getNoteDao().insertTravelType(allTravelTypeDB)
                                                                }
                                                            }
                                                        })

                                                    viewModel.getAllModesOfTransport(sessionManger.getUserID())
                                                        .observe(viewLifecycleOwner, Observer {
                                                            if (it != null) {
                                                                for (i in it.data.indices) {
                                                                    var allTravelModeDB=AllTravelModeDB()
                                                                    allTravelModeDB.mode_of_transport_description=it.data.get(i).modeOfTransportDescription
                                                                    MyRoomDataBase.getInstance(activity!!).getNoteDao().insertTravelMode(allTravelModeDB)
                                                                }
                                                                var intent = Intent(activity!!, HomeActivity::class.java)
                                                                startActivity(intent)
                                                            }
                                                       })
                                                } else {

                                                }
                                            })
                                    } else {

                                    }

                                })

                        } else {
                            Toast.makeText(activity, "null data", Toast.LENGTH_SHORT).show()
                        }
                    })
            }
        }
    }

    override fun getViewModel(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }

}