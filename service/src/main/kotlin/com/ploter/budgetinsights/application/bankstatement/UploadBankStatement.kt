package com.ploter.budgetinsights.application.bankstatement

import com.ploter.budgetinsights.application.bankstatement.command.UploadBankStatementCommand
import com.ploter.budgetinsights.domain.model.Amount
import com.ploter.budgetinsights.domain.model.DatePoint
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatement
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatementFactory
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatementRepository
import com.ploter.budgetinsights.domain.model.bankstatementtemplate.BankStatementTemplateRepository
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionFactory
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionRepository
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationRepository
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassifier
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroup
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupFactory
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupRepository
import com.ploter.budgetinsights.domain.model.importgroup.ImportSourceId
import com.ploter.budgetinsights.domain.model.importgroup.ImportSourceType
import com.ploter.budgetinsights.domain.model.parser.FileParser
import java.util.function.Function

class UploadBankStatement(
  private val bankStatementTemplateRepository: BankStatementTemplateRepository,
  private val bankTransactionFactory: BankTransactionFactory,
  private val bankTransactionRepository: BankTransactionRepository,
  private val bankStatementFactory: BankStatementFactory,
  private val bankStatementRepository: BankStatementRepository,
  private val importGroupFactory: ImportGroupFactory,
  private val importGroupRepository: ImportGroupRepository,
  private val bankTransactionClassifier: BankTransactionClassifier,
  private val bankTransactionClassificationRepository: BankTransactionClassificationRepository,
  private val parsers: List<FileParser>
) {

  fun <T> execute(command: UploadBankStatementCommand, transformer: Function<BankStatement, T>): T {
    val parser: FileParser = parsers.find { it.canParse(command.fileName) }
      ?: throw IllegalArgumentException("Parser not found.")
    val file = parser.parse(command.content)

    val statement: BankStatement = bankStatementFactory.create(command.fileName)
    bankStatementRepository.save(statement)

    val import: ImportGroup = importGroupFactory.create(
      importSourceId = ImportSourceId(statement.id.value),
      importSourceType = ImportSourceType.STATEMENT
    )

    importGroupRepository.save(import)

    val templates = bankStatementTemplateRepository.find()

    val template = templates.sortedWith(Comparator.comparingInt {t ->
      t.getTemplateHeaderNames().count { hn -> file.rows.first().contains(hn) }
    }).last()


    val transactions = file.rows.map { record ->
        val date = record[template.date]
        val amount = record[template.amount]
        val currency = record[template.currency]
        val description = record[template.description]
        val merchant = record[template.merchant]
        val reference = record[template.reference]
        val account = record[template.account]

        bankTransactionFactory.create(
          importGroupId = import.id,
          date = DatePoint.of(date!!),
          amount = Amount.of(amount!!),
          currency = currency!!,
          description = description!!,
          merchant = merchant!!,
          reference = reference!!,
          account = account!!
        )
    }

    val classifications = transactions.mapNotNull { t ->
      bankTransactionClassifier.execute(t)
    }

    bankTransactionRepository.save(transactions)
    bankTransactionClassificationRepository.save(classifications)
    return transformer.apply(statement)
  }

}