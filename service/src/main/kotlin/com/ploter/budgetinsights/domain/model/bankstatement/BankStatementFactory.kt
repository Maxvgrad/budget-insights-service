package com.ploter.budgetinsights.domain.model.bankstatement

interface BankStatementFactory {
  fun create(fileName: String): BankStatement
}