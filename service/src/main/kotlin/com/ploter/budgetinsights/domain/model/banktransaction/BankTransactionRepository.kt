package com.ploter.budgetinsights.domain.model.banktransaction

interface BankTransactionRepository {
  fun save(bankTransaction: BankTransaction)
  fun nextVal(): BankTransactionId
}