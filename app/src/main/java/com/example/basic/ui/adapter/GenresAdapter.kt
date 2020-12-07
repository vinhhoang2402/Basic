package com.example.basic.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basic.data.Genres
import com.example.basic.databinding.GenresItemBinding

class GenresAdapter(
    private val context: Context,
    private val onClick: (Genres) -> Unit
) : RecyclerView.Adapter<GenresAdapter.GenresViewHolder>() {
    private var listGenres: List<Genres> = listOf()

    inner class GenresViewHolder(private val binding: GenresItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(genres: Genres) {
            binding.genres = genres
            binding.ctGenresItem.setOnClickListener {
                onClick(genres)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val genresItemBinding: GenresItemBinding =
            GenresItemBinding.inflate(inflater, parent, false)
        return GenresViewHolder(genresItemBinding)
    }

    override fun getItemCount(): Int = listGenres.size

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        holder.onBind(listGenres[position])
    }

    fun setGenres(genres: List<Genres>) {
        this.listGenres = genres
        notifyDataSetChanged()
    }
}