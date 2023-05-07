package br.com.cvc.evaluation.service

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import mu.KotlinLogging
import java.math.BigDecimal

@ApplicationScoped
class FeeService @Inject constructor(private val feeProvider: FeeProvider) {
    private val logger = KotlinLogging.logger {}

    fun calculateFee(paxPrice: BigDecimal, days: Long): BigDecimal {
        logger.info {"Calculating fee: pax price $paxPrice for $days days" }
        val totalPricePax = paxPrice.multiply(BigDecimal.valueOf(days))

        return totalPricePax.multiply(feeProvider.fee())
    }
}