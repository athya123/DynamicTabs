package com.tare.dummytabs.pojo.entities


import com.google.gson.annotations.SerializedName

data class ProductItems(
    @SerializedName("id")
    var id: String = "",
    @SerializedName("image")
    var image: String = "",
    @SerializedName("name")
    var name: String = "",
    @SerializedName("sellingprice")
    var sellingprice: String = "",
    @SerializedName("visible")
    var visible: String = ""
)