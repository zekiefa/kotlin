package br.com.cvc.evaluation.broker.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class BrokerHotelRoom(@field: JsonProperty("roomID") val roomID: Int,
                           @field: JsonProperty("categoryName") val categoryName: String,
                           @field: JsonProperty("price") val price: Price) {
}
