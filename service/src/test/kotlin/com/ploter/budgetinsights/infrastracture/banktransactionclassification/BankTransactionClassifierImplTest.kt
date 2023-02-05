package com.ploter.budgetinsights.infrastracture.banktransactionclassification

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransaction
import com.ploter.budgetinsights.domain.model.banktransaction.BankTransactionId
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassification
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationFactory
import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryDetailed
import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryFiftyThirtyTwenty
import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryFiftyThirtyTwenty.NEEDS
import com.ploter.budgetinsights.test.fixture.BankTransactionClassificationTestFixture
import com.ploter.budgetinsights.test.fixture.BankTransactionTestFixture
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class BankTransactionClassifierImplTest {

  @ParameterizedTest
  @MethodSource("getData")
  fun `test classification is correct`(
    classificationFile: ClassificationFile,
    bankTransaction: BankTransaction,
    expectedCategoryFiftyThirtyTwenty: CategoryFiftyThirtyTwenty,
    expectedCategoryDetailedValue: String,
    expectedComment: String
  ) {
    val expectedCategoryDetailed = CategoryDetailed(expectedCategoryDetailedValue)
    val classifier = BankTransactionClassifierImpl(
      TestBankTransactionClassificationFactory(),
      classificationFile
    )
    val result = classifier.execute(bankTransaction)

    assertNotNull(result)
    assertNotNull(result.bankTransactionId)
    assertEquals(expectedCategoryFiftyThirtyTwenty, result.categoryFiftyThirtyTwenty)
    assertEquals(expectedCategoryDetailed, result.categoryDetailed)
    assertEquals(expectedComment, result.comment)
  }

  companion object {
    @JvmStatic
    fun getData(): Stream<Arguments> {
      val groceriesCategoryDetailed = CategoryDetailed("groceries")
      val comment = "cmt"
      val groceriesClassification = Classification(
        Triple(NEEDS, groceriesCategoryDetailed, comment)
      )
      val rimiTransaction = BankTransactionTestFixture.aBankTransaction(
        description = "Card transaction of 29.17 EUR issued by Ica Ab/tatari Rimi Is Tallinn",
        merchant = "Ica Ab/tatari Rimi Is Tallinn"
      )

      return listOf(
        Arguments.of(
          ClassificationFile(mapOf(Regex("(RIMI|Rimi|rimi)") to groceriesClassification)),
          rimiTransaction,
          NEEDS,
          "groceries",
          comment
        )
      ).stream()
    }
  }

}

class TestBankTransactionClassificationFactory : BankTransactionClassificationFactory {

  override fun create(
    bankTransactionId: BankTransactionId,
    categoryFiftyThirtyTwenty: CategoryFiftyThirtyTwenty,
    categoryDetailed: CategoryDetailed,
    comment: String
  ): BankTransactionClassification {
    return BankTransactionClassificationTestFixture.aBankTransactionClassification(
      bankTransactionId = bankTransactionId,
      categoryFiftyThirtyTwenty = categoryFiftyThirtyTwenty,
      categoryDetailed = categoryDetailed,
      comment = comment
    )
  }
}