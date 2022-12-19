package com.ploter.budgetinsights.infrastracture.persistence

import com.ploter.budgetinsights.domain.model.bankstatement.BankStatement
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatementId
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatementRepository

class JooqBankStatementRepository(): BankStatementRepository {

    override fun save(bankStatement: BankStatement) {
        TODO("Not yet implemented")
    }

    override fun nextId(): BankStatementId {
        TODO("Not yet implemented")
    }
}