package com.example.core_network.di

import com.example.core_network.GoogleBookApi
import com.example.core_network.retrofit.RetrofitGoogleBookNetwork
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Binds
    fun bindsGoogleBookNetwork(
        googleBookNetwork: RetrofitGoogleBookNetwork
    ): GoogleBookApi

}