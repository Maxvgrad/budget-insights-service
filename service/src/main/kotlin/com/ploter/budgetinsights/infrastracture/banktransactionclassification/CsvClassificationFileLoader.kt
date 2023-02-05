package com.ploter.budgetinsights.infrastracture.banktransactionclassification

import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryDetailed
import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryFiftyThirtyTwenty
import com.ploter.budgetinsights.infrastracture.parser.csv.CsvFileParser
import org.springframework.core.io.Resource

class CsvClassificationFileLoader(
  private val csvFileParser: CsvFileParser,
) {

  fun loadClassificationPatterns(resource: Resource): ClassificationFile {
    return try {
      val result = mutableMapOf<Regex, Classification>()
      csvFileParser.parse(resource.inputStream.readAllBytes()).rows.map { r ->
        result[Regex(r[PATTERN_HEADER]!!)] = Classification(Triple(
          first = CategoryFiftyThirtyTwenty.valueOf(r[CATEGORY_FIFTY_THIRTY_TWENTY]!!.uppercase()),
          second = CategoryDetailed(r[CATEGORY_DETAILED]!!),
          third = r[COMMENT]
        ))
      }
      ClassificationFile(result)
    } catch (e: Exception) {
      throw RuntimeException(
        "Error reading ${resource.filename}: ${e.message}",
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