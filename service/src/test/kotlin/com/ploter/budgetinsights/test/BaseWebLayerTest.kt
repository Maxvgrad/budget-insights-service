package com.ploter.budgetinsights.test

import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.Tables.*
import com.ploter.budgetinsights.presentation.configuration.ApplicationConfiguration
import com.ploter.budgetinsights.presentation.configuration.DataSourceConfiguration
import com.ploter.budgetinsights.presentation.configuration.ParserConfiguration
import com.ploter.budgetinsights.presentation.configuration.PersistenceConfiguration
import com.ploter.budgetinsights.presentation.configuration.SpringConfiguration
import org.jooq.DSLContext
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@ExtendWith(SpringExtension::class)
@WebAppConfiguration
@ContextConfiguration(classes = [
  SpringConfiguration::class,
  ApplicationConfiguration::class,
  DataSourceConfiguration::class,
  PersistenceConfiguration::class,
  ParserConfiguration::class,
])
open class BaseWebLayerTest {

  lateinit var mockMvc: MockMvc
  @Autowired
  lateinit var dsl: DSLContext

  @BeforeEach
  fun setup(wac: WebApplicationContext) {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build()
    cleanDb()
  }

  private fun cleanDb() {
    dsl.deleteFrom(BANK_STATEMENT).execute()
    dsl.deleteFrom(BANK_TRANSACTION).execute()
    dsl.deleteFrom(IMPORT_GROUP).execute()
    dsl.deleteFrom(BANK_TRANSACTION_CLASSIFICATION).execute()
  }

}