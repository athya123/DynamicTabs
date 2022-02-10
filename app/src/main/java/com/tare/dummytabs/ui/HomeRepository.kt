package com.tare.dummytabs.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tare.dummytabs.network.Services
import com.tare.dummytabs.pojo.entities.TabItems
import com.tare.dummytabs.pojo.request.RequestGetTabs
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HomeRepository
@Inject constructor(
    private val services: Services
) {
    private val _tabsList = MutableLiveData<List<TabItems>>()
    val tabsList: LiveData<List<TabItems>>
        get() = _tabsList

    fun fetchTabs(requestGetTabs: RequestGetTabs) {
        services.getTabs(requestGetTabs)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.status == "success") {
                    val list = mutableListOf<TabItems>()
                    for (i in it.data) {
                        list.add(i.value)
                    }
                    _tabsList.postValue(list)
                }
            }, {
            })
    }
}