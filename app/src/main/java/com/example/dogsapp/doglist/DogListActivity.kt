package com.example.dogsapp.doglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogsapp.Dog
import com.example.dogsapp.databinding.ActivityDogListBinding
import com.example.dogsapp.dogdetail.DogDetailActivity
import com.example.dogsapp.dogdetail.DogDetailActivity.Companion.DOG_KEY

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

        adapter.setOnItemClickListener {
            val intent = Intent(this, DogDetailActivity::class.java)
            intent.putExtra(DOG_KEY, it)
            startActivity(intent)
        }
        dogListViewModel.dogList.observe(this){
            dogList ->
            adapter.submitList(dogList)
        }
    }
}