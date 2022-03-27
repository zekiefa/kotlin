package br.com.cvc.evaluation.broker.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class Price(@field: JsonProperty("adult") val adult: BigDecimal,
                 @field: JsonProperty("child") val child: BigDecimal)
