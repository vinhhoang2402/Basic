package com.example.basic.di

import com.example.basic.api.APIClient
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun getGenres()=APIClient.getMovieService()
}