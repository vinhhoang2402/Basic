package com.example.basic.ui

import android.app.Application
import android.media.tv.TvContract
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basic.R
import com.example.basic.data.Genres
import com.example.basic.databinding.ActivityMainBinding
import com.example.basic.databinding.GenresItemBinding
import com.example.basic.ui.adapter.GenresAdapter
import com.example.basic.ui.viewmodel.GenresViewModel
import com.example.basic.ui.viewmodel.GenresViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.properties.ReadOnlyProperty


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val genresViewModel: GenresViewModel by lazy{
        ViewModelProvider(this,GenresViewModelFactory(this.applicationContext))
            .get(GenresViewModel::class.java)
    }

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        genresViewModel.getGenres()
        initControls()
    }

    private fun initControls() {
        val adapter: GenresAdapter = GenresAdapter(this@MainActivity,onClick)
        binding.rvGenres.layoutManager=LinearLayoutManager(this)
        binding.rvGenres.setHasFixedSize(true)
        binding.rvGenres.adapter=adapter
        genresViewModel.genres.observe(this, Observer {
            adapter.setGenres(it.genres)
        })
    }
    private val onClick: (Genres)->Unit={
        Toast.makeText(this, "click ${it.name} ", Toast.LENGTH_SHORT).show()
    }
}