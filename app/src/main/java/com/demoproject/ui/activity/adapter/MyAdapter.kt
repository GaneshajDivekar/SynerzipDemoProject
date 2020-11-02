package com.demoproject.ui.activity.adapter

import android.content.Context
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.demoproject.ui.activity.PlannedActivity
import com.demoproject.ui.fragment.CompletedFragment
import com.demoproject.ui.fragment.HomeFragment
import com.demoproject.ui.fragment.Pending_Fragment

class MyAdapter(
     var context: Context,
     var supportFragmentManager: FragmentManager,
     var tabCount: Int
):FragmentPagerAdapter(supportFragmentManager,FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
{
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return Pending_Fragment()
            }
            1 -> {
                return CompletedFragment()
            }

        }
        throw IllegalStateException("position $position is invalid for this viewpager")
    }

    override fun getCount(): Int {
        return tabCount
    }
}