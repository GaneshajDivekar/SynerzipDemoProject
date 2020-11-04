package com.demoproject.ui.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import com.demoproject.R
import com.demoproject.ui.activity.AddExpenseActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.add_expenses_dialog_layout.*

class AddExpenseDialog(
    var addExpenseActivity: AddExpenseActivity) : Dialog(addExpenseActivity) {
    var strFirstName=""
    var strLastName=""
    var strSecondName=""
    var strAddress=""


    private var onAddExpenseDialogRequestComplete: OnAddExpenseDialogRequestComplete? =null

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.add_expenses_dialog_layout)
        onAddExpenseDialogRequestComplete =  addExpenseActivity as OnAddExpenseDialogRequestComplete
        button7.setOnClickListener {
            strFirstName =firstName.text.toString()
            strSecondName=secondName.text.toString()
            strLastName=editTextTextPersonName4.text.toString()
            strAddress=editTextTextPersonName5.text.toString()
            onAddExpenseDialogRequestComplete!!
                .onAddExpenseDialogRequestComplete(
                    strFirstName,
                    strSecondName,
                    strLastName,
                    strAddress) }
    }

    interface OnAddExpenseDialogRequestComplete {
        fun onAddExpenseDialogRequestComplete(strFirstName: String?,
                                              strSecondName: String?,
                                              strLastName: String?,
                                              strAddress: String?) }

}