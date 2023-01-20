package com.ploter.budgetinsights.domain.model.banktransactionclassification

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionId

interface BankTransactionClassificationFactory {
  fun create(
    bankTransactionId: BankTransactionId,
    categoryFiftyThirtyTwenty: CategoryFiftyThirtyTwenty,
    categoryDetailed: CategoryDetailed,
    comment: String
  ): BankTransactionClassification
}