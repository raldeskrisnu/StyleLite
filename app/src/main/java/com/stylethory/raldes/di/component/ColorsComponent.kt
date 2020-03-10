package com.stylethory.raldes.di.component

import com.stylethory.raldes.di.module.ColorsModule
import com.stylethory.raldes.di.scope.PerActivity
import com.stylethory.raldes.module.fragment.color.ColorsFragment
import dagger.Component

@PerActivity
@Component(modules = arrayOf(ColorsModule::class), dependencies = arrayOf(ApplicationComponent::class))
interface ColorsComponent {

    fun inject (colorsFragment: ColorsFragment)
}