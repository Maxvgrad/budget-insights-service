package com.ploter.budgetinsights.domain.model.bankstatement

interface BankStatementSequence {
    fun nextVal(): BankStatementId
}