package com.ploter.budgetinsights.presentation.configuration

import com.ploter.budgetinsights.presentation.api.v1.banktransaction.csv.CsvMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.multipart.commons.CommonsMultipartResolver
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@EnableWebMvc
@ComponentScan(basePackages = [
  "com.ploter.budgetinsights.presentation.api.v1"
])
class SpringWebMvcConfiguration : WebMvcConfigurer {

  @Bean
  fun multipartResolver() = CommonsMultipartResolver()

  override fun configureMessageConverters(messageConverters: MutableList<HttpMessageConverter<*>>) {
    messageConverters.add(csvMessageConverter())
    messageConverters.add(MappingJackson2HttpMessageConverter())
  }

  fun csvMessageConverter() = CsvMessageConverter()
}