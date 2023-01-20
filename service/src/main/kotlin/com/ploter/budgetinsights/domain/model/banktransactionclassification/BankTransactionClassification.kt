package com.ploter.budgetinsights.domain.model.banktransactionclassification

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionId

class BankTransactionClassification(
  val id: BankTransactionClassificationId,
  val bankTransactionId: BankTransactionId,
  val categoryFiftyThirtyTwenty: CategoryFiftyThirtyTwenty,
  val categoryDetailed: CategoryDetailed,
  val comment: String,
)
