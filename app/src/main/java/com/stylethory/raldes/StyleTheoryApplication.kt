package com.stylethory.raldes

import android.app.Application
import com.stylethory.raldes.di.component.ApplicationComponent
import com.stylethory.raldes.di.component.DaggerApplicationComponent
import com.stylethory.raldes.di.module.ApplicationModule

class StyleTheoryApplication : Application() {

    private var applicationComponent: ApplicationComponent

    init {
        applicationComponent = DaggerApplicationComponent.builder().
            applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

    fun applicationComponent(): ApplicationComponent {
        if (applicationComponent == null) {
            DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        }

        return applicationComponent
    }

}