package com.example.dogsapp.api.dto

import com.squareup.moshi.Json

class DogDTO (val id: Long,
              val index: Int,
              @field:Json(name = "name_en")val name: String,
              @field:Json(name = "dog_type")val type: String,
              @field:Json(name = "height_female")val heightFemale: String,
              @field:Json(name = "height_male")val heightMale: String,
              @field:Json(name = "image_url")val imageUrl: String,
              @field:Json(name = "life_expectancy")val lifeExpectanacy: String,
              @field:Json(name = "temperament_en")val temperament: String,
              @field:Json(name = "weight_female")val weightFemale: String,
              @field:Json(name = "weight_male")val weightMale: String)