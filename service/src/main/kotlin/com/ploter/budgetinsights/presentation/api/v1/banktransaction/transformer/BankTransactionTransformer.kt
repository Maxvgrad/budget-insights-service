package com.ploter.budgetinsights.presentation.api.v1.banktransaction.transformer;

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransaction;
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassification
import com.ploter.budgetinsights.v1.banktransaction.BankTransactionDto
import com.ploter.budgetinsights.v1.banktransaction.BankTransactionResponse
import com.ploter.budgetinsights.v1.banktransactionclassification.BankTransactionClassificationDto

class BankTransactionTransformer {
  fun convert(transactions: List<Pair<BankTransaction, BankTransactionClassification?>>): BankTransactionResponse {
    val transactionDtos = transactions.map { pair ->
      val (transaction, classification) = pair
      BankTransactionDto(
        id = transaction.id.value,
        importGroupId = transaction.importGroupId.value,
        date = transaction.date.value,
        amount = transaction.amount.value,
        currency = transaction.currency,
        description = transaction.description,
        merchant = transaction.merchant,
        reference = transaction.reference,
        account = transaction.account,
        classification = classification?.let { c ->
          BankTransactionClassificationDto(
            categoryFiftyThirtyTwenty = c.categoryFiftyThirtyTwenty.name.lowercase(),
            categoryDetailed = c.categoryDetailed.value,
            comment = c.comment
          )
        }
      )
    }
    return BankTransactionResponse(transactions = transactionDtos)
  }
}