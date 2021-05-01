package usecase

import domain.Conta
import java.math.BigDecimal

class Transferencia {

    fun transferir(origem:Conta, destino:Conta, valor:BigDecimal) {
        if (origem.saldo >= valor) {
            destino.saldo = destino.saldo + valor
            origem.saldo = origem.saldo - valor
        } else
            throw SaldoInsuficiente()
    }

    class SaldoInsuficiente() : Exception("Saldo insuficiente")
}