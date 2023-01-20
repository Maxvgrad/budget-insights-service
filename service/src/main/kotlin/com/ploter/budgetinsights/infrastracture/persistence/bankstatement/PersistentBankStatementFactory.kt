package com.ploter.budgetinsights.infrastracture.persistence.bankstatement

import com.ploter.budgetinsights.domain.model.bankstatement.BankStatement
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatementFactory
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatementSequence

class PersistentBankStatementFactory(
  private val bankStatementSequence: BankStatementSequence
) : BankStatementFactory {

  override fun create(fileName: String): BankStatement {
    return BankStatement(
      id = bankStatementSequence.nextVal(),
      fileName = fileName
    )
  }
}