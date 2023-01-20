package com.ploter.budgetinsights.domain.model.banktransactionclassification

interface BankTransactionClassificationSequence {
  fun nextVal(): BankTransactionClassificationId
}