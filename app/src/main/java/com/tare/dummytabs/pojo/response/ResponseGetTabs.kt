package com.tare.dummytabs.pojo.response


import com.google.gson.annotations.SerializedName
import com.tare.dummytabs.pojo.entities.TabItems

data class ResponseGetTabs(
    @SerializedName("data")
    var `data`: Map<Int, TabItems> = mapOf(),
    @SerializedName("draftcatalogitemcount")
    var draftcatalogitemcount: String = "",
    @SerializedName("status")
    var status: String = ""
)