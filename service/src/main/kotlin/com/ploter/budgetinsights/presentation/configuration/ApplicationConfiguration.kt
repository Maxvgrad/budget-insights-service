package com.ploter.budgetinsights.presentation.configuration

import com.ploter.budgetinsights.application.bankstatement.UploadBankStatement
import com.ploter.budgetinsights.application.banktransactionclassification.ClassifyBankTransaction
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
import org.springframework.context.annotation.Bean

class ApplicationConfiguration {

  @Bean
  fun uploadBankStatement(
    bankTransactionRepository: BankTransactionRepository,
    bankStatementRepository: BankStatementRepository,
    bankStatementFactory: BankStatementFactory,
    importGroupFactory: ImportGroupFactory,
    bankStatementTemplateRepository: BankStatementTemplateRepository,
    bankTransactionFactory: BankTransactionFactory,
    importGroupRepository: ImportGroupRepository,
    classifyBankTransaction: ClassifyBankTransaction,
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
    classifyBankTransaction = classifyBankTransaction,
    bankTransactionClassificationRepository = bankTransactionClassificationRepository,
    parsers = parsers.also { check(it.isNotEmpty()) }
  )

  @Bean
  fun classifyBankTransaction(
    bankTransactionClassificationFactory: BankTransactionClassificationFactory
  ) = ClassifyBankTransaction(
    bankTransactionClassificationFactory = bankTransactionClassificationFactory
  )
}