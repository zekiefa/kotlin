package br.com.cvc.evaluation.service

import java.math.BigDecimal
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class FeeService @Inject constructor(@Inject val feeProvider: FeeProvider) {

    fun calculateFee(paxPrice: BigDecimal, days: Long): BigDecimal {
        val totalPricePax = paxPrice.multiply(BigDecimal.valueOf(days))
        val fee = totalPricePax.multiply(this.feeProvider.fee())

        return fee
    }
}