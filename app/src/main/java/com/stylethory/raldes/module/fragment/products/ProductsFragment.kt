package com.stylethory.raldes.module.fragment.products

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.stylethory.raldes.R
import com.stylethory.raldes.base.BaseFragment
import com.stylethory.raldes.di.component.DaggerProductsComponent
import com.stylethory.raldes.di.module.ProductsModule
import com.stylethory.raldes.model.ProductResponse
import com.stylethory.raldes.module.presenter.ProductsPresenter
import com.stylethory.raldes.module.view.ProductsView
import com.stylethory.raldes.utils.GridItemDecoration
import kotlinx.android.synthetic.main.products_fragment.*
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

    override fun getProduct(productsResponse: ProductResponse) {
        uiview_products.layoutManager = GridLayoutManager(activity,2)

        uiview_products.addItemDecoration(GridItemDecoration(10, 2))

        val movieListAdapter = ProductsAdapter()
        uiview_products.adapter = movieListAdapter
        movieListAdapter.setProducts(productsResponse)
    }

    override fun showLoadingState() {
        uiview_products.visibility = View.GONE
        layout_loading_state.visibility = View.VISIBLE
    }

    override fun erroState(throwable: Throwable) {
        Toast.makeText(activity,"Something error", Toast.LENGTH_SHORT).show()
    }

    override fun hideLoadingState() {
        uiview_products.visibility = View.VISIBLE
        layout_loading_state.visibility = View.GONE
    }

    override fun resolveDaggerDependency() {
        DaggerProductsComponent.builder()
            .applicationComponent(applicationComponent())
            .productsModule(ProductsModule(this))
            .build().inject(this)
    }

}