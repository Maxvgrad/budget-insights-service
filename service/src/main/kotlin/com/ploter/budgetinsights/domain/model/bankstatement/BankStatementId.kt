package com.ploter.budgetinsights.domain.model.bankstatement

@JvmInline
value class BankStatementId(private val value: Long) {
    companion object {
        fun newInstance(): BankStatementId {
            return BankStatementId(3)
        }
    }
}