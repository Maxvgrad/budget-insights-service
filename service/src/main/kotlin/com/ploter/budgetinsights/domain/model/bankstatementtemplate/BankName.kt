package com.ploter.budgetinsights.domain.model.bankstatementtemplate

class BankName(val value: String) {

  companion object {
    val LHV = BankName("LHV")
    val WISE = BankName("Wise")
  }

}