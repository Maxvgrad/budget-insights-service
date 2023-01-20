package com.ploter.budgetinsights.infrastracture.persistence.banktransaction

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionId
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionSequence
import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.Sequences
import org.jooq.DSLContext

class JooqBankTransactionSequence(
  private val dsl: DSLContext
) : BankTransactionSequence {
  override fun nextVal(): BankTransactionId {
    return BankTransactionId(dsl.nextval(Sequences.BANK_TRANSACTION_ID_SEQ).toLong())
  }
}