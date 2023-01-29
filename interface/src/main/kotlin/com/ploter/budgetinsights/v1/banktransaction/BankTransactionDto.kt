package com.ploter.budgetinsights.v1.banktransaction

import com.ploter.budgetinsights.v1.banktransactionclassification.BankTransactionClassificationDto
import java.math.BigDecimal
import java.time.LocalDate

data class BankTransactionDto(
  val id: Long,
  val importGroupId: Long,
  val date: LocalDate,
  val amount: BigDecimal,
  val currency: String,
  val description: String,
  val merchant: String,
  val reference: String,
  val account: String,
  val classification: BankTransactionClassificationDto?
) {

  val debitOrCreditMethod: String = if (amount > BigDecimal.ZERO) "D" else "C"

}