package com.tare.dummytabs.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.tare.dummytabs.R
import com.tare.dummytabs.adapter.FragmentAdapter
import com.tare.dummytabs.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
            viewModel = homeViewModel
        }

        viewPager = binding.viewPager
        viewPager.offscreenPageLimit = 2

        tabLayout = binding.tabLayout
        tabLayout.setupWithViewPager(viewPager)

        val fragmentManager = supportFragmentManager

        homeViewModel.tabsList.observe(this) {
            if (it != null) {
                val adapter = FragmentAdapter(fragmentManager, it)
                viewPager.adapter = adapter
                tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
            }
        }
    }
}