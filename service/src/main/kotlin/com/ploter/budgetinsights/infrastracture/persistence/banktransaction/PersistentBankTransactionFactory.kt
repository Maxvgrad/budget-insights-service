package com.ploter.budgetinsights.infrastracture.persistence.banktransaction

import com.ploter.budgetinsights.domain.model.TimePoint
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransaction
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionFactory
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupId
import java.math.BigDecimal

class PersistentBankTransactionFactory(
  private val sequence: PersistentBankTransactionSequence
) : BankTransactionFactory {
  override fun create(
    importGroupId: ImportGroupId,
    date: TimePoint,
    amount: BigDecimal,
    currency: String,
    description: String,
    merchant: String,
    reference: String,
    account: String
  ): BankTransaction =
    BankTransaction(
      bankTransactionId = sequence.nexVal(),
      importGroupId = importGroupId,
      date = date,
      amount = amount,
      currency = currency,
      description = description,
      merchant = merchant,
      reference = reference,
      account = account
    )
}