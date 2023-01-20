package com.ploter.budgetinsights.infrastracture.persistence.bankstatement

import com.ploter.budgetinsights.domain.model.bankstatement.BankStatement
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatementRepository

class JooqBankStatementRepository(): BankStatementRepository {

    override fun save(bankStatement: BankStatement) {

    }
}