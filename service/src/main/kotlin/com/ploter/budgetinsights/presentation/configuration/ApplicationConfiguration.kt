package com.ploter.budgetinsights.presentation.configuration

import com.ploter.budgetinsights.application.bankstatement.UploadBankStatement
import org.springframework.context.annotation.Bean

//@Configuration
class ApplicationConfiguration {

    @Bean
    fun uploadBankStatement() = UploadBankStatement()
}