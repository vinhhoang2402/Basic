package com.example.basic.repository

import com.example.basic.data.ListGenres
import io.reactivex.Observable
import io.reactivex.Single

interface MovieRepository {
    fun getGenres():Observable<ListGenres>
}