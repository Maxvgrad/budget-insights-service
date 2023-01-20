package com.ploter.budgetinsights.domain.model.banktransactionclassification

interface BankTransactionClassificationRepository {
  fun save(bankTransactionClassifications: List<BankTransactionClassification>)
}