package com.stylethory.raldes.module.fragment.products

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    var page = 1
    var isLoading = false

    var productListAdapter: ProductsAdapter? = null
    var layoutManager: GridLayoutManager? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productListAdapter = ProductsAdapter()

        layoutManager = GridLayoutManager(activity, 2)

        uiview_products.layoutManager = layoutManager

        uiview_products.addItemDecoration(GridItemDecoration(10, 2))

        uiview_products.adapter = productListAdapter


        productsPresenter!!.getProducts(page)

    }

    override fun getContentView(): Int {
        return R.layout.products_fragment
    }

    override fun getProduct(productsResponse: ProductResponse) {

        productListAdapter!!.setProducts(productsResponse)

        uiview_products.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                val visibleItemCount = layoutManager!!.childCount
                val pastVisibleItem = layoutManager!!.findFirstCompletelyVisibleItemPosition()
                val total = productListAdapter!!.itemCount

                if (!isLoading) {

                    if ((visibleItemCount + pastVisibleItem) >= total) {
                        page++
                        productsPresenter!!.getProducts(page)
                    }

                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })

        isLoading = false
    }

    override fun showLoadingState() {
        isLoading = true
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