package com.stylethory.raldes.di.module

import android.content.Context
import com.stylethory.raldes.BuildConfig
import com.stylethory.raldes.Constant
import com.stylethory.raldes.network.AndroidInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApplicationModule(context: Context) {

    var myContext: Context

    init {
        this.myContext = context
    }

    @Singleton
    @Provides
    fun provideGsonFactory(): GsonConverterFactory = GsonConverterFactory.create()


    @Singleton
    @Provides
    fun provideHttpLogginInterceptor(): HttpLoggingInterceptor {

        val httpLoggingInterceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideRxJavaCallAdapter(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Singleton
    @Provides
    @Named("ok-1")
    fun provideOkHttpClient( httpLoggingInterceptor: HttpLoggingInterceptor,
                             androidInterceptor: AndroidInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .addInterceptor(androidInterceptor)
            .build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(@Named("ok-1") okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory,
                        rxJavaCallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJavaCallAdapterFactory)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun androidInterceptor(): AndroidInterceptor = AndroidInterceptor()

    @Provides
    @Singleton
    fun context() : Context = myContext

}