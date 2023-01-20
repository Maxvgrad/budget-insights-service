package com.ploter.budgetinsights.domain.model.bankstatementtemplate

interface BankStatementTemplateRepository {

    fun find(): List<BankStatementTemplate>

}