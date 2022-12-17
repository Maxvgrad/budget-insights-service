package com.ploter.budgetinsights.presentation.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.multipart.commons.CommonsMultipartResolver
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@ComponentScan(basePackages = [
    "com.ploter.budgetinsights.presentation.api.v1"
])
class SpringConfiguration {

    @Bean
    fun multipartResolver() = CommonsMultipartResolver()

}