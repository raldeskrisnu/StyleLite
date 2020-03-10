package com.stylethory.raldes.di.module

import com.stylethory.raldes.di.scope.PerActivity
import com.stylethory.raldes.module.view.ColorsView
import com.stylethory.raldes.service.StyleTheoryLiteService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ColorsModule(colorsView: ColorsView) {

    var colorsView1: ColorsView

    init {
        colorsView1 = colorsView
    }

    @PerActivity
    @Provides
    fun provideMovieService(retrofit: Retrofit): StyleTheoryLiteService {
        return retrofit.create(StyleTheoryLiteService::class.java!!)
    }

    @PerActivity
    @Provides
    fun provideView(): ColorsView {
        return colorsView1
    }
}