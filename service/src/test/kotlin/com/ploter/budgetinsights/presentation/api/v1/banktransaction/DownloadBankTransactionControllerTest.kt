package com.ploter.budgetinsights.presentation.api.v1.banktransaction

import com.ploter.budgetinsights.domain.model.DatePoint
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionRepository
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationRepository
import com.ploter.budgetinsights.test.BaseWebLayerTest
import com.ploter.budgetinsights.test.fixture.BankTransactionClassificationTestFixture.aBankTransactionClassification
import com.ploter.budgetinsights.test.fixture.BankTransactionTestFixture.aBankTransaction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.post
import java.math.BigDecimal

internal class DownloadBankTransactionControllerTest(
  @Autowired val bankTransactionRepository: BankTransactionRepository,
  @Autowired val bankTransactionClassificationRepository: BankTransactionClassificationRepository,
) : BaseWebLayerTest() {

  private val csvFileHeaders = listOf(
    "Date",
    "Amount",
    "Currency",
    "Description",
    "Merchant",
    "Debit(Credit)",
    "Category",
    "Insight",
    "Comment"
  )

  @Test
  fun test() {
    val transactions = listOf(
      aBankTransaction(date = DatePoint.of("2023-01-20")),
      aBankTransaction(date = DatePoint.of("2023-01-15")),
      aBankTransaction(date = DatePoint.of("2023-01-25")),
    ).map { it to aBankTransactionClassification(bankTransactionId = it.id) }
    bankTransactionRepository.save(transactions.map { it.first })
    bankTransactionClassificationRepository.save(transactions.map { it.second })

    val result = mockMvc.post("/transactions") {
      contentType = MediaType.APPLICATION_JSON
    }.andExpect {
      status { isOk() }
      content { contentType("text/csv;charset=UTF-8") }
    }.andReturn()

    val responseBytes = result.response.contentAsByteArray
    val responseText = String(responseBytes)

    val expectedText = csvFileHeaders.joinToString(separator = ",", postfix = "\r\n") +
      transactions.sortedBy { it.first.date.value }.joinToString(separator = "\r\n", postfix = "\r\n")
      { "${it.first.date.value},${it.first.amount.value}," +
        "${it.first.currency},${it.first.description},${it.first.merchant}," +
        "${getDebitOrCreditMethod(it.first.amount.value)},${it.second.categoryFiftyThirtyTwenty.name.lowercase()}," +
        "${it.second.categoryDetailed.value},${it.second.comment}"
      }
    assertEquals(expectedText, responseText)
  }

  private fun getDebitOrCreditMethod(amount: BigDecimal) = if (amount > BigDecimal.ZERO) "D" else "C"

}