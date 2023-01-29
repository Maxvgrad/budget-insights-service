package com.ploter.budgetinsights.domain.model.banktransactionclassification

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionId

interface BankTransactionClassificationRepository {
  fun save(bankTransactionClassifications: List<BankTransactionClassification>)
  fun find(transactionIds: List<BankTransactionId>): List<BankTransactionClassification>
}