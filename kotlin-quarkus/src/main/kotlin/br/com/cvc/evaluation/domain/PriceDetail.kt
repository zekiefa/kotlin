package br.com.cvc.evaluation.domain

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class PriceDetail(@field: JsonProperty("pricePerDayAdult") var pricePerDayAdult: BigDecimal,
                       @field: JsonProperty("pricePerDayChild") var pricePerDayChild: BigDecimal)