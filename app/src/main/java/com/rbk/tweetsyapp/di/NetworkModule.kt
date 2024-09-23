package com.rbk.tweetsyapp.di

import com.rbk.tweetsyapp.api.TwitsyAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io")
            .addConverterFactory(GsonConverterFactory
            .create())
            .build()
    }

    @Provides
    @Singleton
    fun providesTwitsyAPI(retrofit: Retrofit): TwitsyAPI {

        return retrofit.create(TwitsyAPI::class.java)
    }
}