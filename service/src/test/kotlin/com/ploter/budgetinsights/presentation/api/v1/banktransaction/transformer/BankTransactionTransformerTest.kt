package com.ploter.budgetinsights.presentation.api.v1.banktransaction.transformer

import com.ploter.budgetinsights.test.fixture.BankTransactionClassificationTestFixture.aBankTransactionClassification
import com.ploter.budgetinsights.test.fixture.BankTransactionTestFixture.aBankTransaction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

internal class BankTransactionTransformerTest {
  private val transformer = BankTransactionTransformer()

  @Test
  fun `should convert BankTransaction to BankTransactionDto`() {
    val transaction = aBankTransaction()
    val classification = aBankTransactionClassification(comment = "cmt")

    val response = transformer.convert(listOf(transaction to classification))

    assertEquals(1, response.transactions.size)

    val resultTransaction = response.transactions.first()
    assertEquals(transaction.id.value, resultTransaction.id)
    assertEquals(transaction.importGroupId.value, resultTransaction.importGroupId)
    assertEquals(transaction.date.value, resultTransaction.date)
    assertEquals(transaction.amount.value, resultTransaction.amount)
    assertEquals(transaction.currency, resultTransaction.currency)
    assertEquals(transaction.description, resultTransaction.description)
    assertEquals(transaction.merchant, resultTransaction.merchant)
    assertEquals(transaction.reference, resultTransaction.reference)
    assertEquals(transaction.account, resultTransaction.account)
    assertEquals(classification.categoryFiftyThirtyTwenty.name.lowercase(),
      resultTransaction.classification!!.categoryFiftyThirtyTwenty)
    assertEquals(classification.categoryDetailed.value, resultTransaction.classification!!.categoryDetailed)
    assertEquals(classification.comment, resultTransaction.classification!!.comment)
  }


  @Test
  fun `convert should map BankTransaction without BankTransactionClassification to BankTransactionDto`() {
    val transaction = aBankTransaction()

    val response = transformer.convert(listOf(transaction to null))

    assertEquals(1, response.transactions.size)

    val resultTransaction = response.transactions.first()
    assertEquals(transaction.id.value, resultTransaction.id)
    assertEquals(transaction.importGroupId.value, resultTransaction.importGroupId)
    assertEquals(transaction.date.value, resultTransaction.date)
    assertEquals(transaction.amount.value, resultTransaction.amount)
    assertEquals(transaction.currency, resultTransaction.currency)
    assertEquals(transaction.description, resultTransaction.description)
    assertEquals(transaction.merchant, resultTransaction.merchant)
    assertEquals(transaction.reference, resultTransaction.reference)
    assertEquals(transaction.account, resultTransaction.account)
    assertNull(resultTransaction.classification)
  }

  @Test
  fun `should convert list of BankTransactions to BankTransactionResponse`() {
    val transactionsClassificationList = listOf(
      aBankTransaction() to aBankTransactionClassification(),
      aBankTransaction() to null
    )

    val result = transformer.convert(transactionsClassificationList)

    assertEquals(2, result.transactions.size)
  }
}