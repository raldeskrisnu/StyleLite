package com.stylethory.raldes.di.component

import com.stylethory.raldes.di.module.ApplicationModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun exposeRetrofit(): Retrofit

}