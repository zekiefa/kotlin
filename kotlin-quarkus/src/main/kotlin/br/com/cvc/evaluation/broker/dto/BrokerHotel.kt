package br.com.cvc.evaluation.broker.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class BrokerHotel(@field: JsonProperty("id") val id: Int,
                       @field: JsonProperty("cityCode") var cityCode: Int,
                       @field: JsonProperty("cityName") val cityName: String,
                       @field: JsonProperty("name") val name: String,
                       @field: JsonProperty("rooms") val rooms: List<BrokerHotelRoom>)
