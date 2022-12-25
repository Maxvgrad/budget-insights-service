package com.ploter.budgetinsights.infrastracture.persistence.banktransaction

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionId
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionSequence

class PersistentBankTransactionSequence : BankTransactionSequence {
  override fun nexVal(): BankTransactionId {
    TODO("Not yet implemented")
  }
}