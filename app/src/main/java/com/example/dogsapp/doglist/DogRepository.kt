package com.example.dogsapp.doglist

import com.example.dogsapp.Dog
import com.example.dogsapp.api.DogsAPI.retrofitServer
import com.example.dogsapp.api.dto.DogDTO
import com.example.dogsapp.api.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {
    suspend fun downloadDogs(): List<Dog> {
        return withContext(Dispatchers.IO) {
            val dogListApiResponse = retrofitServer.getAllDogs()
            val dogDTOlist = dogListApiResponse.data.dogs
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOlist)
        }
    }
}