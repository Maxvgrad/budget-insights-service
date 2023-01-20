package com.ploter.budgetinsights.infrastracture.persistence.banktransactionclassification

import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationId
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationSequence
import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.Sequences
import org.jooq.DSLContext

class JooqBankTransactionClassificationSequence(
  private val dsl: DSLContext
) : BankTransactionClassificationSequence {
  override fun nextVal(): BankTransactionClassificationId {
    return BankTransactionClassificationId(dsl.nextval(Sequences.BANK_TRANSACTION_CLASSIFICATION_ID_SEQ).toLong())
  }
}