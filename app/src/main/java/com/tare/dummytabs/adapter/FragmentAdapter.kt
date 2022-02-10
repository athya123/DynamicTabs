package com.tare.dummytabs.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tare.dummytabs.pojo.entities.TabItems
import com.tare.dummytabs.ui.fragments.DynamicFragment

class FragmentAdapter(
    manager: FragmentManager,
    private val idList: List<TabItems>
) : FragmentPagerAdapter(manager) {

    override fun getCount(): Int = idList.size

    override fun getItem(position: Int): Fragment {
        return DynamicFragment.newInstance(idList[position].id)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return idList[position].name
    }
}