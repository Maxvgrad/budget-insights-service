package com.ploter.budgetinsights.presentation.api.v1.banktransaction.csv

import com.ploter.budgetinsights.v1.banktransaction.BankTransactionResponse
import org.springframework.http.HttpInputMessage
import org.springframework.http.HttpOutputMessage
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.lang.Nullable
import org.springframework.util.StreamUtils
import java.nio.charset.StandardCharsets

class CsvMessageConverter() : HttpMessageConverter<BankTransactionResponse> {
  private val TEXT_CSV_UTF8 = MediaType("text", "csv", StandardCharsets.UTF_8)

  override fun canWrite(clazz: Class<*>, @Nullable mediaType: MediaType?): Boolean {
    return TEXT_CSV_UTF8.includes(mediaType) && clazz == BankTransactionResponse::class.java
  }

  override fun write(
    bankTransactionResponse: BankTransactionResponse,
    @Nullable contentType: MediaType?,
    outputMessage: HttpOutputMessage
  ) {
    outputMessage.headers.contentType = contentType
    StreamUtils.copy(bankTransactionResponse.toCsv(), outputMessage.body)
  }

  override fun canRead(clazz: Class<*>, @Nullable mediaType: MediaType?): Boolean {
    return false
  }

  override fun read(
    clazz: Class<out BankTransactionResponse?>,
    inputMessage: HttpInputMessage
  ): BankTransactionResponse {
    throw UnsupportedOperationException()
  }

  override fun getSupportedMediaTypes() = listOf(TEXT_CSV_UTF8)
}