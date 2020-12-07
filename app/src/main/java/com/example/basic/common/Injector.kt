package com.example.basic.common

import com.example.basic.api.APIClient
import com.example.basic.repository.MovieRepository
import com.example.basic.repository.MovieRepositoryImp

object Injector {
    @Synchronized
    fun getMovieRepository(): MovieRepository {
        return  MovieRepositoryImp(
            APIClient.getMovieService()
        )
    }
}