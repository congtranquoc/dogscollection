package com.example.dogsapp.doglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogsapp.Dog
import com.example.dogsapp.databinding.ActivityDogListBinding

class DogListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDogListBinding
    private val dogListViewModel: DogListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = DogAdapter()
        val recycler = binding.dogRecycler
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        dogListViewModel.dogList.observe(this){
            dogList ->
            adapter.submitList(dogList)
        }
    }
}