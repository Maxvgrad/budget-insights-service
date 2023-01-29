package com.ploter.budgetinsights.infrastracture.persistence.banktransactionclassification

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionId
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassification
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationId
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationRepository
import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryDetailed
import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryFiftyThirtyTwenty
import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.Tables.BANK_TRANSACTION_CLASSIFICATION
import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.tables.records.BankTransactionClassificationRecord
import org.jooq.DSLContext

class JooqBankTransactionClassificationRepository(private val dsl: DSLContext) :
  BankTransactionClassificationRepository {
  override fun save(bankTransactionClassifications: List<BankTransactionClassification>) {
    dsl.transaction { configuration ->
      val create = dsl.insertInto(BANK_TRANSACTION_CLASSIFICATION)
      bankTransactionClassifications.forEach { t ->
        create.set(toRecord(t)).execute()
      }
    }
  }

  override fun find(transactionIds: List<BankTransactionId>): List<BankTransactionClassification> {
    return dsl.selectFrom(BANK_TRANSACTION_CLASSIFICATION)
      .where(BANK_TRANSACTION_CLASSIFICATION.BANK_TRANSACTION_ID.`in`(transactionIds.map { it.value }))
      .fetch().map { record -> fromRecord(record) }
  }

  private fun toRecord(bankTransactionClassification: BankTransactionClassification): BankTransactionClassificationRecord {
    return BankTransactionClassificationRecord()
      .setId(bankTransactionClassification.id.value)
      .setBankTransactionId(bankTransactionClassification.bankTransactionId.value)
      .setCategoryFiftyThirtyTwenty(bankTransactionClassification.categoryFiftyThirtyTwenty.name)
      .setCategoryDetailed(bankTransactionClassification.categoryDetailed.value)
      .setComment(bankTransactionClassification.comment)
  }

  private fun fromRecord(record: BankTransactionClassificationRecord): BankTransactionClassification {
    return BankTransactionClassification(
      id = BankTransactionClassificationId(record.id),
      bankTransactionId = BankTransactionId(record.bankTransactionId),
      categoryFiftyThirtyTwenty = CategoryFiftyThirtyTwenty.valueOf(record.categoryFiftyThirtyTwenty),
      categoryDetailed = CategoryDetailed(record.categoryDetailed),
      comment = record.comment
    )
  }
}