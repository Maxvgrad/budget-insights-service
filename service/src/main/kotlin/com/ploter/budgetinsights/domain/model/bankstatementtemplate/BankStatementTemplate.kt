package com.ploter.budgetinsights.domain.model.bankstatementtemplate

data class BankStatementTemplate(
        val date: DateHeader,
        val amount: String,
        val currency: String,
        val description: String,
        val merchant: String,
        val reference: String,
        val account: String,
) {
  fun getTemplateHeaderNames() = listOf(
    date.name, amount, currency, description, merchant, reference, account
  )
}