package com.ploter.budgetinsights.application.banktransactionclassification

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransaction
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassification
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationFactory

class ClassifyBankTransaction(
  private val bankTransactionClassificationFactory: BankTransactionClassificationFactory
) {

  fun execute(bankTransaction: BankTransaction): BankTransactionClassification {
    TODO()
  }

}