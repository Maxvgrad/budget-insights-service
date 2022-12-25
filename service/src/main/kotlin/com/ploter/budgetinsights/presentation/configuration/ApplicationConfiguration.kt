package com.ploter.budgetinsights.presentation.configuration

import com.ploter.budgetinsights.application.bankstatement.UploadBankStatement
import com.ploter.budgetinsights.domain.model.bankstatementtemplate.BankStatementTemplateRepository
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionFactory
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupRepository
import com.ploter.budgetinsights.domain.model.parser.FileParser
import org.springframework.context.annotation.Bean

class ApplicationConfiguration {

  @Bean
  fun uploadBankStatement(
    bankStatementTemplateRepository: BankStatementTemplateRepository,
    bankTransactionFactory: BankTransactionFactory,
    importGroupRepository: ImportGroupRepository,
    parsers: List<FileParser>
  ) = UploadBankStatement(
    bankStatementTemplateRepository = bankStatementTemplateRepository,
    bankTransactionFactory = bankTransactionFactory,
    importGroupRepository = importGroupRepository,
    parsers = parsers
  )
}