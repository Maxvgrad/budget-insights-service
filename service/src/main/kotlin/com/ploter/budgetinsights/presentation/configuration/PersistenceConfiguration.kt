package com.ploter.budgetinsights.presentation.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.springframework.context.annotation.Bean
import javax.sql.DataSource

class PersistenceConfiguration {

    @Bean
    fun dataSource(): DataSource {
        val config = HikariConfig()
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/budget-insights")
        config.setUsername("test")
        config.setPassword("test")
        return HikariDataSource(config)
    }

    @Bean(initMethod = "migrate")
    fun flyway(dataSource: DataSource): Flyway {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:/db/migration/")
                .load()
    }

}