package com.ploter.budgetinsights.domain.model.banktransaction

import com.ploter.budgetinsights.domain.model.Amount
import com.ploter.budgetinsights.domain.model.DatePoint
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupId

interface BankTransactionFactory {
  fun create(
    importGroupId: ImportGroupId,
    date: DatePoint,
    amount: Amount,
    currency: String,
    description: String,
    merchant: String,
    reference: String,
    account: String
  ): BankTransaction
}