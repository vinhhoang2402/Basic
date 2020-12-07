package com.example.basic.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basic.data.ListGenres
import com.example.basic.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GenresViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val movieGenres = MutableLiveData<ListGenres>()
    val genres: LiveData<ListGenres> = movieGenres
    private val composite = CompositeDisposable()

    fun getGenres() {
        composite.add(
            movieRepository.getGenres()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    movieGenres.postValue(it)
                }, { ex ->
                    Log.d("vvvv", ex?.printStackTrace().toString())
                    ex?.printStackTrace()
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        composite.dispose()
    }
}