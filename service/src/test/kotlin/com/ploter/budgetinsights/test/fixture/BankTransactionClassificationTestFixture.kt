package com.ploter.budgetinsights.test.fixture

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionId
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassification
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationId
import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryDetailed
import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryFiftyThirtyTwenty
import java.util.concurrent.atomic.AtomicLong

object BankTransactionClassificationTestFixture {
  private val DEFAULT_CATEGORY_FIFTY_THIRTY_TWENTY = CategoryFiftyThirtyTwenty.NEEDS
  private val DEFAULT_CATEGORY_DETAILED = CategoryDetailed("groceries")
  private val DEFAULT_COMMENT = ""
  private val ID_SEQUENCE = AtomicLong(1)

  fun aBankTransactionClassification(
    bankTransactionId: BankTransactionId = BankTransactionId(1),
    categoryFiftyThirtyTwenty: CategoryFiftyThirtyTwenty = DEFAULT_CATEGORY_FIFTY_THIRTY_TWENTY,
    categoryDetailed: CategoryDetailed = DEFAULT_CATEGORY_DETAILED,
    comment: String = DEFAULT_COMMENT
  ): BankTransactionClassification {
    return BankTransactionClassification(
      id = BankTransactionClassificationId(ID_SEQUENCE.getAndIncrement()),
      bankTransactionId = bankTransactionId,
      categoryFiftyThirtyTwenty = categoryFiftyThirtyTwenty,
      categoryDetailed = categoryDetailed,
      comment = comment
    )
  }
}