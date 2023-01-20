package com.ploter.budgetinsights.domain.model.banktransaction

interface BankTransactionSequence {
  fun nextVal(): BankTransactionId
}