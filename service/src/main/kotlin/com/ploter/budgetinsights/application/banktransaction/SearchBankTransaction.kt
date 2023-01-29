package com.ploter.budgetinsights.application.banktransaction

import com.ploter.budgetinsights.application.banktransaction.command.SearchBankTransactionCommand
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransaction
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionId
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionRepository
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassification
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationRepository

class SearchBankTransaction(
  private val bankTransactionRepository: BankTransactionRepository,
  private val bankTransactionClassificationRepository: BankTransactionClassificationRepository
) {

  fun <T> execute(
    command: SearchBankTransactionCommand,
    transformer: (List<Pair<BankTransaction, BankTransactionClassification?>>) -> T
  ): T {
    val transactions: List<BankTransaction> = bankTransactionRepository.findAll().sortedBy { it.date.value }
    val transactionClassificationsMap: Map<BankTransactionId, BankTransactionClassification> =
      bankTransactionClassificationRepository.find(transactions.map { it.id })
        .associateBy { it.bankTransactionId }
    return transformer(transactions.map { it to transactionClassificationsMap[it.id] })
  }

}