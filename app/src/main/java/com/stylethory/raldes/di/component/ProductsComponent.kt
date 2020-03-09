package com.stylethory.raldes.di.component

import com.stylethory.raldes.di.module.ProductsModule
import com.stylethory.raldes.di.scope.PerActivity
import com.stylethory.raldes.module.fragment.products.ProductsFragment
import dagger.Component

@PerActivity
@Component(modules = arrayOf(ProductsModule::class), dependencies = arrayOf(ApplicationComponent::class))
interface ProductsComponent {

    fun inject(productsFragment: ProductsFragment)
}