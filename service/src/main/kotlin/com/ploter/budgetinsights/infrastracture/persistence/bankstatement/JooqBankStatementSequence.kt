package com.ploter.budgetinsights.infrastracture.persistence.bankstatement

import com.ploter.budgetinsights.domain.model.bankstatement.BankStatementId
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatementSequence
import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.Sequences
import org.jooq.DSLContext

class JooqBankStatementSequence(
  private val dsl: DSLContext
) : BankStatementSequence {
  override fun nextVal(): BankStatementId {
    return BankStatementId(dsl.nextval(Sequences.BANK_STATEMENT_ID_SEQ).toLong())
  }
}