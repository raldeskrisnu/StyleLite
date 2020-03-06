package com.stylethory.raldes.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stylethory.raldes.StyleTheoryApplication
import com.stylethory.raldes.di.component.ApplicationComponent

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected open fun resolveDaggerDependency() {}

    protected abstract fun getContentView(): Int

    protected fun applicationComponent(): ApplicationComponent {
        val application = application as StyleTheoryApplication
        return application.applicationComponent()
    }


}