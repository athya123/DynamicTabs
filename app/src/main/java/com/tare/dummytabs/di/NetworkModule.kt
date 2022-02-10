package com.tare.dummytabs.di

import com.tare.dummytabs.network.Services
import com.tare.dummytabs.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideConstants(): Constants {
        return Constants
    }

    @Singleton
    @Provides
    fun provideRetrofit(constants: Constants): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(constants.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    }

    @Singleton
    @Provides
    fun provideNetworkService(retrofit: Retrofit.Builder): Services {
        return retrofit.build()
            .create(Services::class.java)
    }
}