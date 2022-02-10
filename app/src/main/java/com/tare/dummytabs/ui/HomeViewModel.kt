package com.tare.dummytabs.ui

import androidx.lifecycle.ViewModel
import com.tare.dummytabs.pojo.request.RequestGetTabs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val homeRepository: HomeRepository,
) : ViewModel() {

    init {
        fetchTabs()
    }

    val tabsList = homeRepository.tabsList

    private fun fetchTabs() {
        homeRepository.fetchTabs(RequestGetTabs())
    }

}