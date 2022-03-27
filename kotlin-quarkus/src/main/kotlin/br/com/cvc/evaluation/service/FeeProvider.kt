package br.com.cvc.evaluation.service

import io.smallrye.config.ConfigMapping
import java.math.BigDecimal

@ConfigMapping(prefix = "booking")
interface FeeProvider {

    fun fee(): BigDecimal
}