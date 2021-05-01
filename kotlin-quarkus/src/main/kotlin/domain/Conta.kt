package domain

import java.math.BigDecimal

data class Conta (val agencia:Int,
                  val numero:Int,
                  val digito:Int,
                  var saldo:BigDecimal,
                  val usuario:Usuario) {
}