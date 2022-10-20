package com.example.feature_googlebook_list.di

import com.example.core_data.repo.GoogleBookRepository
import com.example.core_data.repo.GoogleBookRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FakeRepositoryModule {

    @Binds
    abstract fun provideGoogleBookRepository(googleBookRepositoryImpl: GoogleBookRepositoryImpl): GoogleBookRepository
    
    
    
}