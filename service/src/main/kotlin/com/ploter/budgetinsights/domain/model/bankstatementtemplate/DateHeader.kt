package com.ploter.budgetinsights.domain.model.bankstatementtemplate

class DateHeader(
  name: String,
  val pattern: String = "yyyy-MM-dd" // ISO-8601
) : BankStatementHeader(name)