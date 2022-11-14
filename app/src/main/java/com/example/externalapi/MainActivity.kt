package com.example.externalapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.ListAdapter
import android.widget.Toast
import com.example.externalapi.databinding.ActivityMainBinding
import com.example.externalapi.models.PostResponse
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()   // инициализация библиотеки
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val postApi = retrofit.create(PostRestApi::class.java) // инициадизация API

        val repository = PostRepository(postApi)
        val adapter = PostListAdapter()
        binding.postListRecyclerview.adapter = adapter

        repository.getAll {
            adapter.setPosts(repository.posts)
        }


    }
}
