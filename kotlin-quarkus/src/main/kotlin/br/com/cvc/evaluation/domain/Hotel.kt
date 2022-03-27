package br.com.cvc.evaluation.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Hotel(@field: JsonProperty("id") val id: Int,
                 @field: JsonProperty("cityName") val cityName: String,
                 @field: JsonProperty("name") val name: String,
                 @field: JsonProperty("rooms") var rooms: List<Room>)