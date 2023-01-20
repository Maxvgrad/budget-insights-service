package com.ploter.budgetinsights.domain.model.bankstatement

interface BankStatementRepository {
    fun save(bankStatement: BankStatement)
}