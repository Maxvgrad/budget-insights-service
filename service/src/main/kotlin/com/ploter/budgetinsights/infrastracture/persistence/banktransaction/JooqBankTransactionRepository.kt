package com.ploter.budgetinsights.infrastracture.persistence.banktransaction

import com.ploter.budgetinsights.domain.model.DatePoint
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransaction
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionId
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionRepository
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupId
import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.Tables.BANK_TRANSACTION
import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.tables.records.BankTransactionRecord
import org.jooq.DSLContext

class JooqBankTransactionRepository(
  private val dsl: DSLContext,
  private val persistentBankTransactionFactory: PersistentBankTransactionFactory
) : BankTransactionRepository {
  override fun save(bankTransactions: List<BankTransaction>) {
    dsl.transaction { configuration ->
      val create = dsl.insertInto(BANK_TRANSACTION)
      bankTransactions.forEach { t ->
        create.set(toRecord(t)).execute()
      }
    }
  }

  override fun findAll(): List<BankTransaction> {
    return dsl.select()
      .from(BANK_TRANSACTION)
      .fetch()
      .map { record -> toDomain(record.into(BANK_TRANSACTION)) }
  }

  private fun toRecord(bankTransaction: BankTransaction): BankTransactionRecord {
    return BankTransactionRecord()
      .setId(bankTransaction.id.value)
      .setImportGroupId(bankTransaction.importGroupId.value)
      .setAmount(bankTransaction.amount.value)
      .setCurrency(bankTransaction.currency)
      .setDate(bankTransaction.date.value)
      .setDescription(bankTransaction.description)
      .setMerchant(bankTransaction.merchant)
      .setReference(bankTransaction.reference)
      .setAccount(bankTransaction.account)
  }

  private fun toDomain(record: BankTransactionRecord): BankTransaction {
    return persistentBankTransactionFactory.persistedBankTransaction(
      id = BankTransactionId(record.id),
      importGroupId = ImportGroupId(record.importGroupId),
      date = DatePoint(record.date),
      amount = record.amount,
      currency = record.currency,
      description = record.description,
      merchant = record.merchant,
      reference = record.reference,
      account = record.account
    )
  }
}