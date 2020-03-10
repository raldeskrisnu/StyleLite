package com.stylethory.raldes.module.presenter

import com.stylethory.raldes.base.BasePresenter
import com.stylethory.raldes.module.view.ColorsView
import com.stylethory.raldes.service.StyleTheoryLiteService
import com.stylethory.raldes.module.view.ProductsView
import com.stylethory.raldes.utils.DisposableUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class ColorsPresenter @Inject constructor() : BasePresenter<ColorsView>() {

    private var disposable: Disposable? = null

    var styleTheoryLiteService: StyleTheoryLiteService? = null
        @Inject set

    fun getColors(pageNumber: Int) {
        DisposableUtils.dispose(disposable);
        view.showLoadingState()

        disposable = styleTheoryLiteService!!.getColors(10,pageNumber).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                view.getColors()
                view.hideLoadingState()
            }, { error ->
                view.hideLoadingState()
                view.erroState(error)
            })
    }

}