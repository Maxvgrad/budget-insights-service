package com.ploter.budgetinsights.test

import com.ploter.budgetinsights.application.bankstatement.UploadBankStatement
import org.springframework.context.annotation.Bean


class ApplicationTestConfiguration {

    @Bean
    fun uploadBankStatement() = UploadBankStatement()

}