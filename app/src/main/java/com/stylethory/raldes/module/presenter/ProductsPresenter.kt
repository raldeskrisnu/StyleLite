package com.stylethory.raldes.module.presenter

import com.stylethory.raldes.base.BasePresenter
import com.stylethory.raldes.module.view.ProductsView
import com.stylethory.raldes.service.StyleTheoryLiteService
import com.stylethory.raldes.utils.DisposableUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ProductsPresenter @Inject constructor() : BasePresenter<ProductsView>() {

    private var disposable: Disposable? = null

    var styleTheoryLiteService: StyleTheoryLiteService? = null
        @Inject set

    fun getProducts(pageNumber: Int) {
        DisposableUtils.dispose(disposable);
        view.showLoadingState()

        disposable = styleTheoryLiteService!!.getProducts(10,pageNumber).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                view.getProduct(it)
                view.hideLoadingState()
            }, { error ->
                view.hideLoadingState()
                view.erroState(error)
            })

    }
}