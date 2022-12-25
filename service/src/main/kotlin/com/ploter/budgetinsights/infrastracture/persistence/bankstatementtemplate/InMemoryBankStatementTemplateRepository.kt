package com.ploter.budgetinsights.infrastracture.persistence.bankstatementtemplate

import com.ploter.budgetinsights.domain.model.bankstatementtemplate.BankStatementTemplate
import com.ploter.budgetinsights.domain.model.bankstatementtemplate.BankStatementTemplateRepository

class InMemoryBankStatementTemplateRepository: BankStatementTemplateRepository {

    override fun find(): BankStatementTemplate = BankStatementTemplate()

}