package com.tare.dummytabs.pojo.entities


import com.google.gson.annotations.SerializedName

data class TabItems(
    @SerializedName("colorcode")
    var colorcode: String = "",
    @SerializedName("createdon")
    var createdon: String = "",
    @SerializedName("disablecatalog")
    var disablecatalog: String = "",
    @SerializedName("id")
    var id: String = "",
    @SerializedName("image")
    var image: String = "",
    @SerializedName("name")
    var name: String = "",
    @SerializedName("productcount")
    var productcount: String = ""
)