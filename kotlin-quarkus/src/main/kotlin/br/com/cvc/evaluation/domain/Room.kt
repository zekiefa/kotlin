package br.com.cvc.evaluation.domain

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class Room(@field: JsonProperty("roomID") val roomID: Int,
                @field: JsonProperty("categoryName") val categoryName: String,
                @field: JsonProperty("totalPrice") var totalPrice: BigDecimal,
                @field: JsonProperty("priceDetail") val priceDetail: PriceDetail)