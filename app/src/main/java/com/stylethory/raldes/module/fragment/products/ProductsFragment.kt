package com.stylethory.raldes.module.fragment.products

import android.os.Bundle
import android.view.View
import com.stylethory.raldes.R
import com.stylethory.raldes.base.BaseFragment
import com.stylethory.raldes.view.ProductsView

class ProductsFragment: BaseFragment(), ProductsView  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getContentView(): Int {
        return R.layout.products_fragment
    }

    override fun getProduct() {

    }

}