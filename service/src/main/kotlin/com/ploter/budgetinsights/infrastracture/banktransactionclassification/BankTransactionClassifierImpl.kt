package com.ploter.budgetinsights.infrastracture.banktransactionclassification

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransaction
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassification
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationFactory
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassifier

class BankTransactionClassifierImpl(
  private val bankTransactionClassificationFactory: BankTransactionClassificationFactory,
  private val classificationFile: ClassificationFile
): BankTransactionClassifier {

  override fun execute(bankTransaction: BankTransaction): BankTransactionClassification? {
    return classificationFile.data.entries
      .find { it.key.matches(bankTransaction.description) || it.key.matches(bankTransaction.merchant) }
      ?.value?.let { c ->
        bankTransactionClassificationFactory.create(
          bankTransactionId = bankTransaction.id,
          categoryFiftyThirtyTwenty = c.data.first,
          categoryDetailed = c.data.second,
          comment = c.data.third ?: ""
        )
      }
  }
}