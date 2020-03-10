package com.stylethory.raldes.module.fragment.color

import android.os.Bundle
import android.view.View
import com.stylethory.raldes.R
import com.stylethory.raldes.base.BaseFragment
import com.stylethory.raldes.di.component.DaggerColorsComponent
import com.stylethory.raldes.di.module.ColorsModule
import com.stylethory.raldes.module.presenter.ColorsPresenter
import com.stylethory.raldes.module.view.ColorsView
import javax.inject.Inject

class ColorsFragment : BaseFragment(), ColorsView {


    var colorsPresenter: ColorsPresenter? = null
        @Inject set


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        colorsPresenter!!.getColors(1)
    }

    override fun getContentView(): Int {
        return R.layout.colors_fragment
    }

    override fun getColors() {

    }

    override fun showLoadingState() {

    }

    override fun erroState(throwable: Throwable) {

    }

    override fun hideLoadingState() {

    }

    override fun resolveDaggerDependency() {
        DaggerColorsComponent.builder()
            .applicationComponent(applicationComponent())
            .colorsModule(ColorsModule(this))
            .build().inject(this)
    }
}