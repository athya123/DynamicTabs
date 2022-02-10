package com.tare.dummytabs.pojo.request


import com.google.gson.annotations.SerializedName

data class RequestGetTabs(
    @SerializedName("apikey")
    var apikey: String = "164362357261f7b494c9ddf",
    @SerializedName("storeid")
    var storeid: String = "2",
    @SerializedName("userid")
    var userid: String = "2"
)