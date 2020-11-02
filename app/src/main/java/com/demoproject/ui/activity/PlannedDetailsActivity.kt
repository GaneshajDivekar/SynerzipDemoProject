package com.demoproject.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.demoproject.R
import com.demoproject.databinding.ActivityPlannedDetailsBinding
import com.demoproject.ui.base.BaseActivity
import com.demoproject.ui.base.BaseViewModel
import com.demoproject.viewmodel.PlannedDetailsViewModel
import com.demoproject.viewmodel.PlannedViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_planned_details.*

class PlannedDetailsActivity : BaseActivity<PlannedDetailsViewModel>(), OnMapReadyCallback,View.OnClickListener {
    private lateinit var activityPlannedDetailsBinding: ActivityPlannedDetailsBinding

    private lateinit var mMap: GoogleMap

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPlannedDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_planned_details)
        activityPlannedDetailsBinding.viewModel = viewModel
        activityPlannedDetailsBinding.lifecycleOwner = this
        var code = intent.getStringExtra("abc")

        Toast.makeText(this,""+code,Toast.LENGTH_SHORT).show()
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button3.visibility= View.GONE
    }

    override fun getViewModel(): Class<PlannedDetailsViewModel> {
        return PlannedDetailsViewModel::class.java
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
    override fun onMapReady(googleMap: GoogleMap?) {
        if (googleMap != null) {
            mMap = googleMap
            val sydney= LatLng(-34.0,151.0)
            mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
            }

    }

    @SuppressLint("ResourceAsColor")
    override fun onClick(p0: View?) {
        when (p0) {
       button2 -> {
                button2.setBackgroundColor(R.color.colorPrimary)
                button2.isClickable = false
                button2.isEnabled = false
                button3.visibility = View.VISIBLE
            }
            button3 -> {
                button3.setBackgroundColor(R.color.colorPrimary)
                button3.isClickable = false
                button3.isEnabled = false
            }
        }
    }
}