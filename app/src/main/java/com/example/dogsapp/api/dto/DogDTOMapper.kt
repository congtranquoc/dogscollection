package com.example.dogsapp.api.dto

import com.example.dogsapp.Dog

class DogDTOMapper {

    private fun fromDogDTOtoDogDomain(dogDTO: DogDTO):Dog{
        return Dog(dogDTO.id,
                    dogDTO.index,
                    dogDTO.name,
                    dogDTO.type,
                    dogDTO.heightFemale,
                    dogDTO.heightMale,
                    dogDTO.imageUrl,
                    dogDTO.lifeExpectanacy,
                    dogDTO.temperament,
                    dogDTO.weightFemale,
                    dogDTO.weightMale)
    }

    fun fromDogDTOListToDogDomainList(dogDTOList: List<DogDTO>): List<Dog>{
        return dogDTOList.map { fromDogDTOtoDogDomain(it) }
    }
}