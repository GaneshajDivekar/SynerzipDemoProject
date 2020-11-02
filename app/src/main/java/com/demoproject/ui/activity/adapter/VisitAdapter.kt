package com.demoproject.ui.activity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demoproject.databinding.ItemPlannedItemBinding
import com.demoproject.model.VisitDB
import com.demoproject.ui.activity.PlannedActivity
import com.demoproject.ui.activity.interfaces.ItemClick
import com.demoproject.ui.fragment.Pending_Fragment
import java.util.ArrayList

class VisitAdapter(
    var plannedActivity: PlannedActivity,
    var allVisit: ArrayList<VisitDB>,
    var itemClick: ItemClick
) : RecyclerView.Adapter<VisitAdapter.RecyclerViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPlannedItemBinding.inflate(layoutInflater)
        return RecyclerViewHolder(binding)
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
        val currentUser = allVisit!![position]
        holder.binding.visit = currentUser
        holder.binding.executePendingBindings()
        holder.itemView.setOnClickListener {
            itemClick.onClick(position)
        }
    }
    class RecyclerViewHolder(val binding: ItemPlannedItemBinding) : RecyclerView.ViewHolder(binding.root)



}