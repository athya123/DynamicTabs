package com.tare.dummytabs.pojo.response


import com.google.gson.annotations.SerializedName
import com.tare.dummytabs.pojo.entities.ProductItems

data class ResponseGetTabItems(
    @SerializedName("data")
    var `data`: Map<Int, ProductItems> = mapOf(),
    @SerializedName("status")
    var status: String = ""
)