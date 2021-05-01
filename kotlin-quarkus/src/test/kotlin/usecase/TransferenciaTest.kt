package usecase

import com.github.jairovsky.fixturefactory.kotlin.gimme
import domain.Conta
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

internal class TransferenciaTest {

    private val transferencia = Transferencia()

    @Test
    @DisplayName("Deve transferir com saldo disponível")
    fun `deve transferir com sucesso quando o saldo for suficiente`() {
        // Arranges
        val origem = gimme<Conta>("conta_valida_fulano")
        val destino = gimme<Conta>("conta_valida_ciclano")

        // Act
        transferencia.transferir(origem, destino, 100.toBigDecimal())

        // Asserts
        assertAll("sucesso",
            { assertThat(origem.saldo, `is`(0.toBigDecimal())) },
            { assertThat(destino.saldo, `is`(300.toBigDecimal()))}
        )
    }

    @Test
    @DisplayName("Não deve transferir com saldo insuficiente")
    fun `nao deve transferir quando o saldo for insuficiente`() {
        // Arranges
        val origem = gimme<Conta>("conta_valida_fulano")
        val destino = gimme<Conta>("conta_valida_sem_saldo")

        assertThrows<Transferencia.SaldoInsuficiente> {
            this.transferencia.transferir(origem, destino, 200.toBigDecimal())
        }
    }
}