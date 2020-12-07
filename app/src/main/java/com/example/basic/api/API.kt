package com.example.basic.api

import com.example.basic.data.ListGenres
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("list")
    fun getGenres(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Observable<ListGenres>
}