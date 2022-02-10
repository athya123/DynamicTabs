package com.tare.dummytabs.network

import com.tare.dummytabs.pojo.request.RequestGetTabItems
import com.tare.dummytabs.pojo.request.RequestGetTabs
import com.tare.dummytabs.pojo.response.ResponseGetTabItems
import com.tare.dummytabs.pojo.response.ResponseGetTabs
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface Services {

    @POST("product-catalog-list")
    fun getTabs(@Body requestGetTabs: RequestGetTabs): Single<ResponseGetTabs>

    @POST("product-catalog-product-list")
    fun getTabItems(@Body requestGetTabItems: RequestGetTabItems): Observable<ResponseGetTabItems>
}