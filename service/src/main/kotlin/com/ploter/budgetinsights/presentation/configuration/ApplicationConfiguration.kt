package com.ploter.budgetinsights.presentation.configuration

import com.ploter.budgetinsights.application.bankstatement.UploadBankStatement
import com.ploter.budgetinsights.application.banktransaction.SearchBankTransaction
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatementFactory
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatementRepository
import com.ploter.budgetinsights.domain.model.bankstatementtemplate.BankStatementTemplateRepository
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionFactory
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionRepository
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationFactory
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationRepository
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupFactory
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupRepository
import com.ploter.budgetinsights.domain.model.parser.FileParser
import com.ploter.budgetinsights.infrastracture.banktransactionclassification.BankTransactionClassifierImpl
import com.ploter.budgetinsights.infrastracture.banktransactionclassification.CsvClassificationFileLoader
import com.ploter.budgetinsights.infrastracture.parser.csv.CsvFileParser
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.core.io.Resource

class ApplicationConfiguration {

  @Suppress("LongParameterList")
  @Bean
  fun uploadBankStatement(
    bankTransactionRepository: BankTransactionRepository,
    bankStatementRepository: BankStatementRepository,
    bankStatementFactory: BankStatementFactory,
    importGroupFactory: ImportGroupFactory,
    bankStatementTemplateRepository: BankStatementTemplateRepository,
    bankTransactionFactory: BankTransactionFactory,
    importGroupRepository: ImportGroupRepository,
    classifyBankTransaction: BankTransactionClassifierImpl,
    bankTransactionClassificationRepository: BankTransactionClassificationRepository,
    parsers: List<FileParser>
  ) = UploadBankStatement(
    bankTransactionRepository = bankTransactionRepository,
    bankStatementTemplateRepository = bankStatementTemplateRepository,
    bankStatementRepository = bankStatementRepository,
    bankTransactionFactory = bankTransactionFactory,
    bankStatementFactory = bankStatementFactory,
    importGroupRepository = importGroupRepository,
    importGroupFactory = importGroupFactory,
    bankTransactionClassifier = classifyBankTransaction,
    bankTransactionClassificationRepository = bankTransactionClassificationRepository,
    parsers = parsers.also { check(it.isNotEmpty()) }
  )

  @Bean
  fun searchBankTransaction(
    bankTransactionRepository: BankTransactionRepository,
    bankTransactionClassificationRepository: BankTransactionClassificationRepository,
  ) = SearchBankTransaction(
    bankTransactionRepository = bankTransactionRepository,
    bankTransactionClassificationRepository = bankTransactionClassificationRepository,
  )

  @Bean
  fun classifyBankTransaction(
    bankTransactionClassificationFactory: BankTransactionClassificationFactory,
    @Value("classpath:classification.csv") resourceFile: Resource,
    csvFileParser: CsvFileParser
  ) = BankTransactionClassifierImpl(
    bankTransactionClassificationFactory = bankTransactionClassificationFactory,
    classificationFile = CsvClassificationFileLoader(csvFileParser = csvFileParser)
      .loadClassificationPatterns(resourceFile)
  )
}