package com.stylethory.raldes.di.module

import com.stylethory.raldes.di.scope.PerActivity
import com.stylethory.raldes.service.StyleTheoryLiteService
import com.stylethory.raldes.module.view.ProductsView
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class ProductsModule(productView: ProductsView) {

    var productsView1:ProductsView

    init {
        productsView1 = productView
    }

    @PerActivity
    @Provides
    fun provideMovieService(retrofit: Retrofit): StyleTheoryLiteService {
        return retrofit.create(StyleTheoryLiteService::class.java!!)
    }

    @PerActivity
    @Provides
    fun provideView(): ProductsView {
        return productsView1
    }
}