package com.example.task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
data class Movie(
    val title: String,
    val description: String,
    val posterUrl: Int
)


class MovieAdapter(private val items:List<Movie>):RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val cardView: CardView = view.findViewById(R.id.cardView)
        val titleTextView: TextView = view.findViewById(R.id.Title)
        val descriptionTextView: TextView = view.findViewById(R.id.discreption)
        val posterImageView: ImageView = view.findViewById(R.id.poster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(
            R.layout.movie_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = items[position]
        holder.titleTextView.text = movie.title
        holder.descriptionTextView.text = movie.description
        holder.posterImageView.setImageResource(movie.posterUrl)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}