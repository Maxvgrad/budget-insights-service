package com.ploter.budgetinsights.domain.model

import java.math.BigDecimal

@JvmInline
value class Amount
private constructor(val value: BigDecimal) {
  companion object {
    fun of(amount: String): Amount {
      return Amount(
        BigDecimal(amount).setScale(8)
      )
    }

    fun of(amount: BigDecimal): Amount {
      return Amount(amount)
    }
  }
}