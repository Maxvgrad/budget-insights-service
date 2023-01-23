package com.ploter.budgetinsights.infrastracture.persistence.banktransactionclassification

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionId
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassification
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationFactory
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationSequence
import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryDetailed
import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryFiftyThirtyTwenty

class PersistentBankTransactionClassificationFactory(
  private val bankTransactionClassificationSequence: BankTransactionClassificationSequence
) : BankTransactionClassificationFactory {

  override fun create(
    bankTransactionId: BankTransactionId,
    categoryFiftyThirtyTwenty: CategoryFiftyThirtyTwenty,
    categoryDetailed: CategoryDetailed,
    comment: String?
  ): BankTransactionClassification {
    return BankTransactionClassification(
      id = bankTransactionClassificationSequence.nextVal(),
      bankTransactionId = bankTransactionId,
      categoryFiftyThirtyTwenty = categoryFiftyThirtyTwenty,
      categoryDetailed = categoryDetailed,
      comment = comment
    )
  }
}