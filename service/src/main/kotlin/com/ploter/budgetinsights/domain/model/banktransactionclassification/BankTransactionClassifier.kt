package com.ploter.budgetinsights.domain.model.banktransactionclassification

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransaction

interface BankTransactionClassifier {
    fun execute(bankTransaction: BankTransaction): BankTransactionClassification?
}