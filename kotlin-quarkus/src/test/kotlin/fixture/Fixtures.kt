package fixture

import com.github.jairovsky.fixturefactory.kotlin.FixtureDefinitions
import domain.Conta
import domain.Usuario

object Fixtures : FixtureDefinitions({
    "conta_valida_fulano" {
        Conta(1, 1234, 4, 100.toBigDecimal(),
            Usuario("502.348.640-01", "Fulano", "Brandão")
        )
    }

    "conta_valida_ciclano" {
        Conta(1, 1234, 4, 200.toBigDecimal(),
            Usuario("723.058.170-29", "Ciclano", "do Fulano")
        )
    }

    "conta_valida_sem_saldo" {
        Conta(2, 5678, 5, 0.toBigDecimal(),
            Usuario("066.384.540-80", "Ciclano", "Gonzalez"))
    }
})