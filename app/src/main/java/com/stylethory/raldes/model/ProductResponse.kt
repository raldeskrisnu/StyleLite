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
    var price: Price,

    @SerializedName("details")
    @Expose
    var details: String,

    @SerializedName("featured_image")
    @Expose
    var featureImage: String,

    @SerializedName("designer")
    @Expose
    var designer: List<Designer>
)

data class Price (

    @SerializedName("currency")
    @Expose
    var currency: String,

    @SerializedName("amount")
    @Expose
    var amount: Int
)

data class Designer (

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String
)