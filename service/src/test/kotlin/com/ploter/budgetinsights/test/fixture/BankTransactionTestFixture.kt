package com.ploter.budgetinsights.test.fixture

import com.ploter.budgetinsights.domain.model.Amount
import com.ploter.budgetinsights.domain.model.DatePoint
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransaction
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionId
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupId
import java.time.LocalDate
import java.util.concurrent.atomic.AtomicLong

object BankTransactionTestFixture {
  private val DEFAULT_IMPORT_GROUP_ID = ImportGroupId(1)
  private val DEFAULT_AMOUNT = Amount.of("1.0")
  private val DEFAULT_DATE = DatePoint(LocalDate.of(2020, 1, 1))
  private const val DEFAULT_CURRENCY = "USD"
  private const val DEFAULT_DESCRIPTION = "description"
  private const val DEFAULT_MERCHANT = "merchant"
  private const val DEFAULT_REFERENCE = "reference"
  private const val DEFAULT_ACCOUNT = "account"
  private val ID_SEQUENCE = AtomicLong(1)

  fun aBankTransaction(
    importGroupId: ImportGroupId = DEFAULT_IMPORT_GROUP_ID,
    date: DatePoint = DEFAULT_DATE,
    amount: Amount = DEFAULT_AMOUNT,
    currency: String = DEFAULT_CURRENCY,
    description: String = DEFAULT_DESCRIPTION,
    merchant: String = DEFAULT_MERCHANT,
    reference: String = DEFAULT_REFERENCE,
    account: String = DEFAULT_ACCOUNT
  ): BankTransaction {
    return BankTransaction(
      id = BankTransactionId(ID_SEQUENCE.getAndIncrement()),
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
}
