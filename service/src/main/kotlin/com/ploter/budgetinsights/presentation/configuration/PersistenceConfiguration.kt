package com.ploter.budgetinsights.presentation.configuration

import com.ploter.budgetinsights.domain.model.bankstatement.BankStatementSequence
import com.ploter.budgetinsights.domain.model.banktransactionclassification.JooqBankTransactionClassificationRepository
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupSequence
import com.ploter.budgetinsights.infrastracture.persistence.bankstatement.JooqBankStatementRepository
import com.ploter.budgetinsights.infrastracture.persistence.bankstatement.JooqBankStatementSequence
import com.ploter.budgetinsights.infrastracture.persistence.bankstatement.PersistentBankStatementFactory
import com.ploter.budgetinsights.infrastracture.persistence.bankstatementtemplate.InMemoryBankStatementTemplateRepository
import com.ploter.budgetinsights.infrastracture.persistence.banktransaction.JooqBankTransactionRepository
import com.ploter.budgetinsights.infrastracture.persistence.banktransaction.JooqBankTransactionSequence
import com.ploter.budgetinsights.infrastracture.persistence.banktransaction.PersistentBankTransactionFactory
import com.ploter.budgetinsights.infrastracture.persistence.banktransactionclassification.JooqBankTransactionClassificationSequence
import com.ploter.budgetinsights.infrastracture.persistence.banktransactionclassification.PersistentBankTransactionClassificationFactory
import com.ploter.budgetinsights.infrastracture.persistence.importgroup.JooqImportGroupRepository
import com.ploter.budgetinsights.infrastracture.persistence.importgroup.JooqImportGroupSequence
import com.ploter.budgetinsights.infrastracture.persistence.importgroup.PersistentImportGroupFactory
import org.jooq.ConnectionProvider
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DefaultConfiguration
import org.springframework.context.annotation.Bean

class PersistenceConfiguration {

  @Bean
  fun configuration(connectionProvider: ConnectionProvider) =
    DefaultConfiguration().apply {
      set(connectionProvider)
      setSQLDialect(SQLDialect.POSTGRES)
    }.dsl()

  @Bean
  fun bankStatementTemplateRepository() = InMemoryBankStatementTemplateRepository()

  @Bean
  fun bankTransactionSequence(dsl: DSLContext) = JooqBankTransactionSequence(dsl)

  @Bean
  fun bankTransactionFactory(
    bankTransactionSequence: JooqBankTransactionSequence
  ) = PersistentBankTransactionFactory(
    sequence = bankTransactionSequence
  )

  @Bean
  fun bankTransactionRepository(dsl: DSLContext) = JooqBankTransactionRepository(dsl)

  @Bean
  fun importGroupRepository() = JooqImportGroupRepository()

  @Bean
  fun importGroupSequence(dsl: DSLContext) = JooqImportGroupSequence(dsl)

  @Bean
  fun importGroupFactory(importGroupSequence: ImportGroupSequence) =
    PersistentImportGroupFactory(importGroupSequence)

  @Bean
  fun bankStatementSequence(dsl: DSLContext) = JooqBankStatementSequence(dsl)

  @Bean
  fun bankStatementRepository() = JooqBankStatementRepository()

  @Bean
  fun bankStatementFactory(bankStatementSequence: BankStatementSequence) =
    PersistentBankStatementFactory(bankStatementSequence)

  @Bean
  fun bankTransactionClassificationSequence(dsl: DSLContext) = JooqBankTransactionClassificationSequence(dsl)

  @Bean
  fun bankTransactionClassificationFactory(
    bankTransactionClassificationSequence: JooqBankTransactionClassificationSequence
  ) = PersistentBankTransactionClassificationFactory(
    bankTransactionClassificationSequence = bankTransactionClassificationSequence
  )

  @Bean
  fun bankTransactionClassificationRepository() = JooqBankTransactionClassificationRepository()

}