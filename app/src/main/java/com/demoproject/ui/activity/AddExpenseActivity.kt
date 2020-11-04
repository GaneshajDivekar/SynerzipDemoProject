package com.demoproject.ui.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.demoproject.R
import com.demoproject.database.MyRoomDataBase
import com.demoproject.databinding.ActivityAddExpenseBinding
import com.demoproject.model.AllTravelModeDB
import com.demoproject.model.AllTravelTypeDB
import com.demoproject.ui.base.BaseActivity
import com.demoproject.ui.dialog.AddExpenseDialog
import com.demoproject.viewmodel.AddExpenseViewModel

class AddExpenseActivity : BaseActivity<AddExpenseViewModel>(),
    AddExpenseDialog.OnAddExpenseDialogRequestComplete {
    private lateinit var addExpenseBinding: ActivityAddExpenseBinding
    val REQUEST_CODE = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addExpenseBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_expense)
        addExpenseBinding.viewModel = viewModel
        addExpenseBinding.lifecycleOwner = this


        showTypeDropDown(MyRoomDataBase.getInstance(this).getNoteDao().loadAllType())
        showModeDropDown(MyRoomDataBase.getInstance(this).getNoteDao().loadAllMode())
        addExpenseBinding.imageView2.setOnClickListener {
            SelectCamera()
        }
        addExpenseBinding.button4.setOnClickListener {
            var addExpensesDialog = AddExpenseDialog(this@AddExpenseActivity)
            addExpensesDialog.getWindow()
                ?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            addExpensesDialog.show()

        }
    }



    private fun SelectCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data != null){
            addExpenseBinding.imageView4.setImageBitmap(data.extras!!.get("data") as Bitmap)
        }
    }
    private fun showModeDropDown(loadAllMode: List<AllTravelModeDB>) {
        var itemBrandNameList = ArrayList<String>()
        for (i in loadAllMode.indices) {
            itemBrandNameList.add(loadAllMode.get(i).mode_of_transport_description!!)
        }
        val arrayAdapter = ArrayAdapter<String>(this@AddExpenseActivity,R.layout.spinner_custom_textview,itemBrandNameList)
        addExpenseBinding!!.autoCompleteTextView3.setAdapter(arrayAdapter)
        addExpenseBinding!!.autoCompleteTextView3.setOnClickListener {
            addExpenseBinding!!.autoCompleteTextView3.showDropDown()
        }
    }

    private fun showTypeDropDown(loadAllType: List<AllTravelTypeDB>) {
        var itemBrandNameList = ArrayList<String>()
        for (i in loadAllType.indices) {
            itemBrandNameList.add(loadAllType.get(i).typeTravelDescriptions!!)
        }
        val arrayAdapter =
            ArrayAdapter<String>(this@AddExpenseActivity,R.layout.spinner_custom_textview,itemBrandNameList)
        addExpenseBinding!!.autoCompleteTextView.setAdapter(arrayAdapter)
        addExpenseBinding!!.autoCompleteTextView.setOnClickListener {
        addExpenseBinding!!.autoCompleteTextView.showDropDown()
        }
        addExpenseBinding!!.autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            for (i in loadAllType.indices) {
                if (loadAllType.get(i).typeTravelDescriptions == itemBrandNameList.get(position)) {
                    var active = loadAllType.get(i).active!!
                    var typeTravelid = loadAllType.get(i).active
                    Toast.makeText(application,"active"+typeTravelid,Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun getViewModel(): Class<AddExpenseViewModel> {
        return AddExpenseViewModel::class.java
    }

    override fun onAddExpenseDialogRequestComplete(
        strFirstName: String?,
        strSecondName: String?,
        strLastName: String?,
        strAddress: String?) {

        System.out.println("Test="+strFirstName+strSecondName+strLastName+strAddress)

    }
}