package com.ploter.budgetinsights.test

import com.ploter.budgetinsights.presentation.configuration.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
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

  @BeforeEach
  fun setup(wac: WebApplicationContext) {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build()
  }

}