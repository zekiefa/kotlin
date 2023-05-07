package br.com.cvc.evaluation.service

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import java.math.BigDecimal

@ApplicationScoped
class FeeService @Inject constructor(private val feeProvider: FeeProvider) {

    fun calculateFee(paxPrice: BigDecimal, days: Long): BigDecimal {
        val totalPricePax = paxPrice.multiply(BigDecimal.valueOf(days))

        return totalPricePax.multiply(feeProvider.fee())
    }
}