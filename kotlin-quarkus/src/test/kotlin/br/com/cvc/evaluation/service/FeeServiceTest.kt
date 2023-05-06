package br.com.cvc.evaluation.service

import io.mockk.every
import io.mockk.mockk
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.DayOfWeek

@QuarkusTest
class FeeServiceTest {
    private val feeProvider: FeeProvider = mockk()

    private val feeService = FeeService(feeProvider)

    @Test
    fun `Calculating a fee`() {
        // Arranges
        every { feeProvider.fee() } returns BigDecimal.valueOf(0.70)
        val paxPrice = BigDecimal.valueOf(259.67)
        val days = java.lang.Long.valueOf(DayOfWeek.values().size.toLong())

        // Act
        val result = feeService.calculateFee(paxPrice, days)

        // Assert
        Assertions.assertEquals(
            0, paxPrice.multiply(BigDecimal.valueOf(days))
                .multiply(feeProvider.fee()).compareTo(result)
        )
    }
}