package co.tiagoaguiar.netflixremake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = MainAdapter()
        val rv: RecyclerView = findViewById(R.id.rv_main)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

    }

    private inner class MainAdapter : RecyclerView.Adapter<MainAdapter.MovieViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MovieViewHolder {
            val view = layoutInflater.inflate(R.layout.movie_item, parent, false)
            return MovieViewHolder(view)
        }

        override fun onBindViewHolder(p0: MovieViewHolder, p1: Int) {

        }

        override fun getItemCount(): Int {
            return 60
        }


        private inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        }


    }
}