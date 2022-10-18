package com.example.core_data.di

import com.example.core_data.repo.GoogleBookRepository
import com.example.core_data.repo.GoogleBookRepositoryImpl
import com.example.core_data.source.remote.GoogleBookRemoteDataSource
import com.example.core_data.source.remote.GoogleBookRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindGoogleBookRepository(
        googleBookRepositoryImpl: GoogleBookRepositoryImpl
    ): GoogleBookRepository

    @Binds
    fun bindGoogleBookRemoteDataSource(
        googleBookRemoteDataSourceImpl: GoogleBookRemoteDataSourceImpl
    ): GoogleBookRemoteDataSource
}