package com.ploter.budgetinsights.infrastracture.persistence.banktransaction

import com.ploter.budgetinsights.domain.model.Amount
import com.ploter.budgetinsights.domain.model.DatePoint
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransaction
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionFactory
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionId
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupId
import java.math.BigDecimal

class PersistentBankTransactionFactory(
  private val sequence: JooqBankTransactionSequence
) : BankTransactionFactory {
  override fun create(
    importGroupId: ImportGroupId,
    date: DatePoint,
    amount: Amount,
    currency: String,
    description: String,
    merchant: String,
    reference: String,
    account: String
  ): BankTransaction =
    createInternal(
      id = sequence.nextVal(),
      importGroupId = importGroupId,
      date = date,
      amount = amount,
      currency = currency,
      description = description,
      merchant = merchant,
      reference = reference,
      account = account
    )

  fun persistedBankTransaction(
    id: BankTransactionId,
    importGroupId: ImportGroupId,
    date: DatePoint,
    amount: BigDecimal,
    currency: String,
    description: String,
    merchant: String,
    reference: String,
    account: String): BankTransaction =
    createInternal(
      id = id,
      importGroupId = importGroupId,
      date = date,
      amount = Amount.of(amount),
      currency = currency,
      description = description,
      merchant = merchant,
      reference = reference,
      account = account
    )

  private fun createInternal(
    id: BankTransactionId,
    importGroupId: ImportGroupId,
    date: DatePoint,
    amount: Amount,
    currency: String,
    description: String,
    merchant: String,
    reference: String,
    account: String
  ): BankTransaction =
    BankTransaction(
      id = id,
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