package com.ploter.budgetinsights.infrastracture.persistence.bankstatementtemplate

import com.ploter.budgetinsights.domain.model.bankstatementtemplate.BankStatementTemplate
import com.ploter.budgetinsights.domain.model.bankstatementtemplate.BankStatementTemplateRepository

class InMemoryBankStatementTemplateRepository : BankStatementTemplateRepository {

  override fun find(): List<BankStatementTemplate> = listOf(
    BankStatementTemplate(
      date = "Date",
      amount = "Amount",
      currency = "Currency",
      description = "Description",
      merchant = "Merchant",
      reference = "Reference",
      account = "Account",
    ),
    BankStatementTemplate(
      date = "Date",
      amount = "Amount",
      currency = "Currency",
      description = "Description",
      merchant = "Merchant",
      reference = "Reference",
      account = "Account",
    )
  )

}