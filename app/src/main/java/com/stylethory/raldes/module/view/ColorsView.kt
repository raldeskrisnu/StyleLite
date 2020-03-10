package com.stylethory.raldes.module.view

import com.stylethory.raldes.base.BaseView
import com.stylethory.raldes.model.ColorsResponse

interface ColorsView : BaseView {

    fun getColors(colorsResponse: ColorsResponse)
}