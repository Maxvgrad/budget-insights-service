package com.ploter.budgetinsights.infrastracture.persistence.banktransaction

import com.ploter.budgetinsights.domain.model.Amount
import com.ploter.budgetinsights.domain.model.DatePoint
import com.ploter.budgetinsights.test.BaseWebLayerTest
import com.ploter.budgetinsights.test.fixture.BankTransactionTestFixture.aBankTransaction
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate
import kotlin.test.assertEquals

class JooqBankTransactionRepositoryTest(
  @Autowired val repository: JooqBankTransactionRepository
) : BaseWebLayerTest() { // TODO: Introduce a different parent class

  @Test
  fun `save should insert bank transactions into the database`() {
    val bankTransactions = listOf(
      aBankTransaction(
        amount = Amount.Companion.of("1.0"),
        date = DatePoint(LocalDate.of(2020, 1, 1)),
        currency = "USD"),
      aBankTransaction(amount = Amount.Companion.of("2.0"), date = DatePoint(LocalDate.of(2020, 2, 2)),
        currency = "USD")
    )

    repository.save(bankTransactions)

    val bankTransactionsFromDb = repository.findAll()

    assertEquals(bankTransactions, bankTransactionsFromDb)
  }
}