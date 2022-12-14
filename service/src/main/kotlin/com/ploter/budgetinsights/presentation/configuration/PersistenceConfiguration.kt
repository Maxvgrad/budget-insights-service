package com.ploter.budgetinsights.presentation.configuration

import com.ploter.budgetinsights.infrastracture.persistence.bankstatementtemplate.InMemoryBankStatementTemplateRepository
import com.ploter.budgetinsights.infrastracture.persistence.banktransaction.PersistentBankTransactionFactory
import com.ploter.budgetinsights.infrastracture.persistence.banktransaction.PersistentBankTransactionSequence
import com.ploter.budgetinsights.infrastracture.persistence.importgroup.PersistentImportGroupRepository
import org.jooq.ConnectionProvider
import org.jooq.SQLDialect
import org.jooq.impl.DefaultConfiguration
import org.springframework.context.annotation.Bean

class PersistenceConfiguration {

  @Bean
  fun configuration(connectionProvider: ConnectionProvider) =
    DefaultConfiguration().apply {
      set(connectionProvider)
      setSQLDialect(SQLDialect.POSTGRES)
    }

    @Bean
    fun bankStatementTemplateRepository() = InMemoryBankStatementTemplateRepository()

    @Bean
    fun bankTransactionSequence() = PersistentBankTransactionSequence()

    @Bean
    fun bankTransactionFactory(
      bankTransactionSequence: PersistentBankTransactionSequence
    ) = PersistentBankTransactionFactory(
      sequence = bankTransactionSequence
    )

  @Bean
  fun importGroupRepository() = PersistentImportGroupRepository()

}