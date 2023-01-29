package com.ploter.budgetinsights.infrastracture.banktransactionclassification

import com.ploter.budgetinsights.domain.model.banktransaction.BankTransaction
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassification
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassificationFactory
import com.ploter.budgetinsights.domain.model.banktransactionclassification.BankTransactionClassifier
import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryDetailed
import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryFiftyThirtyTwenty
import com.ploter.budgetinsights.infrastracture.parser.csv.CsvFileParser
import org.springframework.core.io.Resource

private typealias Classification = Triple<CategoryFiftyThirtyTwenty, CategoryDetailed, String?>
private typealias ClassificationFile = Map<Regex, Classification>

class InMemoryClassifyBankTransaction(
  private val bankTransactionClassificationFactory: BankTransactionClassificationFactory,
  private val resourceFile: Resource,
  private val csvFileParser: CsvFileParser
): BankTransactionClassifier {

  private val classificationFile: ClassificationFile = loadClassificationPatterns(resourceFile)

  override fun execute(bankTransaction: BankTransaction): BankTransactionClassification? {
    return classificationFile.entries
      .find { it.key.matches(bankTransaction.description) || it.key.matches(bankTransaction.merchant) }
      ?.value?.let { c ->
        bankTransactionClassificationFactory.create(
          bankTransactionId = bankTransaction.id,
          categoryFiftyThirtyTwenty = c.first,
          categoryDetailed = c.second,
          comment = c.third ?: ""
        )
      }
  }

  private fun loadClassificationPatterns(resource: Resource): ClassificationFile {
    return try {
      val result = mutableMapOf<Regex, Classification>()
      csvFileParser.parse(resource.inputStream.readAllBytes()).rows.map { r ->
        result[Regex(r[PATTERN_HEADER]!!)] = Triple(
          first = CategoryFiftyThirtyTwenty.valueOf(r[CATEGORY_FIFTY_THIRTY_TWENTY]!!.uppercase()),
          second = CategoryDetailed(r[CATEGORY_DETAILED]!!),
          third = r[COMMENT]
        )
      }
      result
    } catch (e: Exception) {
      throw RuntimeException(
        "Error reading ${resourceFile.filename}: ${e.message}",
        e
      )
    }
  }

  companion object {
    private const val PATTERN_HEADER = "pattern"
    private const val CATEGORY_FIFTY_THIRTY_TWENTY = "categoryFiftyThirtyTwenty"
    private const val CATEGORY_DETAILED = "categoryDetailed"
    private const val COMMENT = "comment"
  }

}