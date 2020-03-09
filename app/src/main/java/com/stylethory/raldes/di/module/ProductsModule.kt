package com.stylethory.raldes.di.module

import com.stylethory.raldes.di.scope.PerActivity
import com.stylethory.raldes.model.ProductResponse
import com.stylethory.raldes.view.ProductsView
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
    fun provideMovieService(retrofit: Retrofit): ProductResponse {
        return retrofit.create(ProductResponse::class.java!!)
    }

    @PerActivity
    @Provides
    fun provideView(): ProductsView {
        return productsView1
    }
}