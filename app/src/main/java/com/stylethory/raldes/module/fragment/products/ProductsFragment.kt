package com.stylethory.raldes.module.fragment.products

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.stylethory.raldes.R
import com.stylethory.raldes.base.BaseFragment
import com.stylethory.raldes.di.component.DaggerColorsComponent
import com.stylethory.raldes.di.component.DaggerProductsComponent
import com.stylethory.raldes.di.module.ColorsModule
import com.stylethory.raldes.di.module.ProductsModule
import com.stylethory.raldes.module.presenter.ProductsPresenter
import com.stylethory.raldes.module.view.ProductsView
import javax.inject.Inject

class ProductsFragment: BaseFragment(), ProductsView  {

    var productsPresenter: ProductsPresenter? = null
        @Inject set

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productsPresenter!!.getProducts(1)
    }

    override fun getContentView(): Int {
        return R.layout.products_fragment
    }

    override fun getProduct() {

    }

    override fun showLoadingState() {

    }

    override fun erroState(throwable: Throwable) {
        Toast.makeText(activity,"Something error", Toast.LENGTH_SHORT).show()
    }

    override fun hideLoadingState() {

    }

    override fun resolveDaggerDependency() {
        DaggerProductsComponent.builder()
            .applicationComponent(applicationComponent())
            .productsModule(ProductsModule(this))
            .build().inject(this)
    }

}