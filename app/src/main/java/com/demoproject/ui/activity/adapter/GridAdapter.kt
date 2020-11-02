package com.demoproject.ui.activity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.demoproject.R
import com.demoproject.databinding.ItemSelectionItemBinding
import com.demoproject.model.HomeScreenDB
import com.demoproject.ui.activity.interfaces.ItemClick

class GridAdapter(
    var context: Context,
    var allItemDaos: List<HomeScreenDB>,
    var itemClick: ItemClick?
):RecyclerView.Adapter<GridAdapter.GridViewHolder>()
{
    override fun getItemViewType(position: Int): Int {
        return position
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GridViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemSelectionItemBinding.inflate(layoutInflater)
        return GridViewHolder(binding)

    }

    override fun onBindViewHolder(listViewHolder: GridViewHolder,position: Int) {
        val currentUser = allItemDaos!![position]
        listViewHolder.binding.home = currentUser
        listViewHolder.binding.executePendingBindings()

        listViewHolder.itemView.setOnClickListener {
         itemClick?.onClick(position)
        }

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return if (allItemDaos == null) {
            0
        } else {
            allItemDaos!!.size
        }
    }


   class GridViewHolder(val binding: ItemSelectionItemBinding) : RecyclerView.ViewHolder(binding.root)


}