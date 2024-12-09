package com.example.task2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task2.databinding.ActivitySecondryBinding // Make sure the correct binding is used

class SecondryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondryBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the correct layout and bind it
        binding = ActivitySecondryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Define the movie list with resource IDs for images
        val movieList = listOf(
            Movie("The Dark Knight", "2008", R.drawable.poster2),
            Movie("fight Clup", "1999",R.drawable.poster10),
            Movie("Star wars", "1977",R.drawable.poster3),
            Movie("Back to the future", "1985",R.drawable.poster4),
            Movie("Lord of the Rings", "2001",R.drawable.poster5),
            Movie("The Matrix", "1999",R.drawable.poster6),
            Movie("Inception", "2010",R.drawable.poster7),
            Movie("The Shawshank Redemptio", "1949",R.drawable.poster1),
            Movie("The GodFather", "1972",R.drawable.poster9),

        )

        // Set up the adapter and RecyclerView
        movieAdapter = MovieAdapter(movieList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = movieAdapter

        // Enable edge-to-edge for a full-screen experience
        enableEdgeToEdge()

        // Handle insets (optional)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
