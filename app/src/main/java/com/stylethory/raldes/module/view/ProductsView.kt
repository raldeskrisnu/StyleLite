package com.stylethory.raldes.module.view

import com.stylethory.raldes.base.BaseView
import com.stylethory.raldes.model.ProductResponse

interface ProductsView : BaseView {

    fun getProduct(productResponse: ProductResponse)
}