package com.stylethory.raldes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ColorsResponse(

    @SerializedName("colors")
    @Expose
    var color : List<ColorsList>
)

data class ColorsList(


    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("code")
    @Expose
    var code: String

)