package com.ploter.budgetinsights.infrastracture.persistence.bankstatementtemplate

import com.ploter.budgetinsights.domain.model.bankstatementtemplate.BankName
import com.ploter.budgetinsights.domain.model.bankstatementtemplate.BankStatementTemplate
import com.ploter.budgetinsights.domain.model.bankstatementtemplate.BankStatementTemplateRepository
import com.ploter.budgetinsights.domain.model.bankstatementtemplate.DateHeader

class InMemoryBankStatementTemplateRepository : BankStatementTemplateRepository {

  override fun find(): List<BankStatementTemplate> = listOf(
    //LHV
    BankStatementTemplate(
      bankName = BankName.LHV,
      date = DateHeader(name = "Date"),
      amount = "Amount",
      currency = "Currency",
      description = "Description",
      merchant = "Sender/receiver name",
      reference = "Reference number",
      account = "Sender/receiver account",
    ),
    //Wise
    BankStatementTemplate(
      bankName = BankName.WISE,
      date = DateHeader(name = "Date", pattern = "dd-MM-yyyy"),
      amount = "Amount",
      currency = "Currency",
      description = "Description",
      merchant = "Merchant",
      reference = "Payment Reference",
      account = "",
    )
  )

}