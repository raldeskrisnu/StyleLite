package com.stylethory.raldes.module.fragment.color

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stylethory.raldes.R
import com.stylethory.raldes.base.BaseFragment
import com.stylethory.raldes.di.component.DaggerColorsComponent
import com.stylethory.raldes.di.module.ColorsModule
import com.stylethory.raldes.model.ColorsResponse
import com.stylethory.raldes.module.presenter.ColorsPresenter
import com.stylethory.raldes.module.view.ColorsView
import com.stylethory.raldes.utils.GridItemDecoration
import kotlinx.android.synthetic.main.colors_fragment.uiview_colors_recylerview
import kotlinx.android.synthetic.main.colors_fragment.layout_loading_states

import javax.inject.Inject

class ColorsFragment : BaseFragment(), ColorsView {

    var colorsPresenter: ColorsPresenter? = null
        @Inject set

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        colorsPresenter!!.getColors()

    }

    override fun getContentView(): Int {
        return R.layout.colors_fragment
    }

    override fun getColors(colorsResponse: ColorsResponse) {

        uiview_colors_recylerview.layoutManager = GridLayoutManager(activity,4)

        uiview_colors_recylerview.addItemDecoration(GridItemDecoration(10, 2))

        val colorListAdapter = ColorsAdapter()
        uiview_colors_recylerview.adapter = colorListAdapter
        colorListAdapter.setColors(colorsResponse)

    }

    override fun showLoadingState() {
        layout_loading_states.visibility = View.VISIBLE
        uiview_colors_recylerview.visibility = View.GONE
    }

    override fun erroState(throwable: Throwable) {
        Toast.makeText(activity,"Something error", Toast.LENGTH_SHORT).show()
    }

    override fun hideLoadingState() {
        layout_loading_states.visibility = View.GONE
        uiview_colors_recylerview.visibility = View.VISIBLE
    }

    override fun resolveDaggerDependency() {
        DaggerColorsComponent.builder()
            .applicationComponent(applicationComponent())
            .colorsModule(ColorsModule(this))
            .build().inject(this)
    }
}