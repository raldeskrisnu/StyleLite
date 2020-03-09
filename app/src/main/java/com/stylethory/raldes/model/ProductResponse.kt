package com.stylethory.raldes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductResponse(

    @SerializedName("products")
    @Expose
    var product : List<Product>

) : Serializable


data class Product (

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("gallery")
    @Expose
    var gallery: List<String>,

    @SerializedName("price")
    @Expose
    var price: List<Price>,

    @SerializedName("details")
    @Expose
    var details: String
)

data class Price (

    @SerializedName("currency")
    @Expose
    var currency: String,

    @SerializedName("amount")
    @Expose
    var amount: Int
)