package com.ploter.budgetinsights.presentation.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.jooq.ConnectionProvider
import org.jooq.SQLDialect
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultConfiguration
import org.springframework.context.annotation.Bean
import javax.sql.DataSource

class DataSourceConfiguration {

  @Bean
  fun dataSource(): DataSource {
    val config = HikariConfig()
    config.jdbcUrl = "jdbc:postgresql://localhost:5432/budget-insights"
    config.username = "test"
    config.password = "test"
    config.driverClassName = "org.postgresql.Driver"
    return HikariDataSource(config)
  }

  @Bean(initMethod = "migrate")
  fun flyway(dataSource: DataSource): Flyway {
    return Flyway.configure()
      .dataSource(dataSource)
      .locations("classpath:/db/migration/")
      .baselineOnMigrate(true)
      .load()
  }

  @Bean
  fun dataSourceConnectionProvider(dataSource: DataSource): DataSourceConnectionProvider {
    return DataSourceConnectionProvider(dataSource)
  }

  @Bean
  fun configuration(connectionProvider: ConnectionProvider) =
    DefaultConfiguration().apply {
      set(connectionProvider)
      setSQLDialect(SQLDialect.POSTGRES)
    }

}