package com.ploter.budgetinsights.domain.model.banktransaction

interface BankTransactionRepository {
  fun save(bankTransactions: List<BankTransaction>)
  fun findAll(): List<BankTransaction>
}