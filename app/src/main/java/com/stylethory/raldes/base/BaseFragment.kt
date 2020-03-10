package com.stylethory.raldes.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.stylethory.raldes.StyleTheoryApplication
import com.stylethory.raldes.di.component.ApplicationComponent

abstract class BaseFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val root = inflater.inflate(getContentView(), container, false)

        return root
    }

    protected abstract fun getContentView(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resolveDaggerDependency()

    }

    protected open fun resolveDaggerDependency() {}

    protected fun applicationComponent(): ApplicationComponent? {
        return if (activity != null)
            (activity!!.application as StyleTheoryApplication).applicationComponent()
        else
            null
    }
}