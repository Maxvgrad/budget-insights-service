package com.ploter.budgetinsights.domain.model.banktransaction

@JvmInline
value class BankTransactionId
private constructor(private val value: Long) {
    companion object {
        fun newInstance(): BankTransactionId {
            return BankTransactionId(3) // TODO:
        }
    }
}