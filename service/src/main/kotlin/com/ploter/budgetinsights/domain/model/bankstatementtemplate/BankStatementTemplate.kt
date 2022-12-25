package com.ploter.budgetinsights.domain.model.bankstatementtemplate

data class BankStatementTemplate(
        val date: String = "Date",
        val amount: String = "Amount",
        val currency: String = "Currency",
        val description: String = "Description",
        val merchant: String = "Merchant",
        val reference: String = "Reference",
        val account: String = "Account",
)