package com.ploter.budgetinsights.domain.model.banktransaction

import com.ploter.budgetinsights.domain.model.TimePoint
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupId
import java.math.BigDecimal

interface BankTransactionFactory {
  fun create(
    importGroupId: ImportGroupId,
    date: TimePoint,
    amount: BigDecimal,
    currency: String,
    description: String,
    merchant: String,
    reference: String,
    account: String
  ): BankTransaction
}