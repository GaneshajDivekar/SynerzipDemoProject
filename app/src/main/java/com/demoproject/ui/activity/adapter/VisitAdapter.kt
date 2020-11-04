package com.demoproject.ui.activity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.demoproject.R
import com.demoproject.databinding.ItemPlannedItemBinding
import com.demoproject.model.VisitDB
import com.demoproject.ui.activity.PlannedActivity
import com.demoproject.ui.activity.interfaces.ItemClick
import com.demoproject.ui.fragment.Pending_Fragment
import java.util.ArrayList


class VisitAdapter(
    var plannedActivity: Context,
    var allVisit: ArrayList<VisitDB>,
    var itemClick: ItemClick
) : RecyclerView.Adapter<VisitAdapter.RecyclerViewHolder>()
{


    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tv_ATMID: TextView = view.findViewById(R.id.tv_ATMID)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(plannedActivity).inflate(
                R.layout.item_planned_item,
                parent,
                false
            )
        )

    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return if (allVisit == null) {
            0
        } else {
            allVisit!!.size
        }
    }

    override fun onBindViewHolder(holder: VisitAdapter.RecyclerViewHolder, position: Int) {
          val currentUser = allVisit!![position].visitCategoryCode
          holder.tv_ATMID.setText(currentUser)
          holder.itemView.setOnClickListener {
              itemClick.onClick(position)
          }
    }
//    class RecyclerViewHolder(val binding: ItemPlannedItemBinding) : RecyclerView.ViewHolder(binding.root)


}
/*
override fun onBindViewHolder(holder: VisitAdapter.RecyclerViewHolder, position: Int) {
    val currentUser = allVisit!![position]
    holder.binding.visit = currentUser
    holder.binding.executePendingBindings()
    holder.itemView.setOnClickListener {
        itemClick.onClick(position)
    }*/

