package com.ploter.budgetinsights.domain.model.banktransaction

interface BankTransactionSequence {
  fun nexVal(): BankTransactionId
}