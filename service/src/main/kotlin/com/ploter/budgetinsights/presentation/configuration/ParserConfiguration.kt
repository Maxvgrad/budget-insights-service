package com.ploter.budgetinsights.presentation.configuration

import com.ploter.budgetinsights.infrastracture.parser.csv.CsvFileParser
import org.springframework.context.annotation.Bean

class ParserConfiguration {
    @Bean
    fun fileParser() = CsvFileParser()
}