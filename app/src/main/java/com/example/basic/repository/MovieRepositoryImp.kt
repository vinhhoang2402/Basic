package com.example.basic.repository

import com.example.basic.api.API
import com.example.basic.common.DataConstants.API_KEY
import com.example.basic.common.DataConstants.LANGUAGE
import com.example.basic.data.ListGenres
import io.reactivex.Observable
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val api: API
) : MovieRepository {
    override fun getGenres(): Observable<ListGenres> {
        return api.getGenres(API_KEY,LANGUAGE)
    }
}