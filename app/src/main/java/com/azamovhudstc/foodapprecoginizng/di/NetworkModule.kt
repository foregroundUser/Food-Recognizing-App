package com.azamovhudstc.foodapprecoginizng.di

import android.content.Context
import com.azamovhudstc.foodapprecoginizng.app.App
import com.azamovhudstc.foodapprecoginizng.data.remote.api.EdamanApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @[Provides Singleton]
    fun getOkHTTPClient(@ApplicationContext context: Context): OkHttpClient = OkHttpClient.Builder()
        .build()


    @[Provides Singleton Named("EdamanApi")]
    fun getUnsplashRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.edamam.com/api/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    @Provides
    fun getUnsplashApi(@Named("EdamanApi") retrofit: Retrofit): EdamanApi =
        retrofit.create(EdamanApi::class.java)

}