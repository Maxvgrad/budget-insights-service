package com.ploter.budgetinsights.application.bankstatement

import com.ploter.budgetinsights.application.bankstatement.command.UploadBankStatementCommand
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatement
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatementId
import com.ploter.budgetinsights.domain.model.bankstatementtemplate.BankStatementTemplateRepository
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionFactory
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupId
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupRepository
import com.ploter.budgetinsights.domain.model.parser.FileParser
import java.util.function.Function

class UploadBankStatement(
  private val bankStatementTemplateRepository: BankStatementTemplateRepository,
  private val bankTransactionFactory: BankTransactionFactory,
  private val importGroupRepository: ImportGroupRepository,
  private val parsers: List<FileParser>
) {

  fun <T> execute(command: UploadBankStatementCommand, transformer: Function<BankStatement, T>): T {

    val parser: FileParser = parsers.find { it.canParse(command.fileName) } ?: throw IllegalArgumentException("Parser not found.")
    val file = parser.parse(command.content)

//    val reader = InputStreamReader(ByteArrayInputStream(command.content), "UTF-8")
//    val parser = CSVParser(reader, CSVFormat.DEFAULT)

//    importGroupRepository.save(ImportGroup(
//
//    ))

    val bankStatementTemplate = bankStatementTemplateRepository.find()
    val importGroupId = ImportGroupId.newInstance()

      file.rows.map { record ->
//        val date = record.get(bankStatementTemplate.date)
//        val amount = record.get(bankStatementTemplate.amount)
//        val currency = record.get(bankStatementTemplate.currency)
//        val description = record.get(bankStatementTemplate.description)
//        val merchant = record.get(bankStatementTemplate.merchant)
//        val reference = record.get(bankStatementTemplate.reference)
//        val account = record.get(bankStatementTemplate.account)

//        bankTransactionFactory.create(
//          importGroupId = importGroupId,
//          date = TimePoint(Instant.parse(date)),
//          amount = BigDecimal(amount),
//          currency = currency,
//          description = description,
//          merchant = merchant,
//          reference = reference,
//          account = account
//        )
      }

    return transformer.apply(BankStatement(
      id = BankStatementId.newInstance(),
      fileName = command.fileName
    ))
  }

}