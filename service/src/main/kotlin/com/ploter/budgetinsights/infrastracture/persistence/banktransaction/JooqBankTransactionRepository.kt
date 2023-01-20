package com.ploter.budgetinsights.infrastracture.persistence.banktransaction

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransaction
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionRepository
import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.Tables.BANK_TRANSACTION
import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.tables.records.BankTransactionRecord
import org.jooq.DSLContext

class JooqBankTransactionRepository(
  private val dsl: DSLContext
) : BankTransactionRepository {
  override fun save(bankTransactions: List<BankTransaction>) {
    dsl.transaction { configuration ->
      val create = dsl.insertInto(BANK_TRANSACTION)
      bankTransactions.forEach { t ->
        create.set(toRecord(t)).execute()
      }
    }
  }

  private fun toRecord(bankTransaction: BankTransaction): BankTransactionRecord {
    return BankTransactionRecord()
      .setId(bankTransaction.id.value)
      .setImportGroupId(bankTransaction.importGroupId.value)
      .setAmount(bankTransaction.amount)
      .setDate(bankTransaction.date.asOffsetDateTime())
      .setDescription(bankTransaction.description)
      .setMerchant(bankTransaction.merchant)
      .setReference(bankTransaction.reference)
      .setAccount(bankTransaction.account)
  }
}