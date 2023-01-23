package com.ploter.budgetinsights.infrastracture.parser.csv

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CsvFileParserTest {
  private val parser = CsvFileParser()
  private val testFile = this::class.java.classLoader.getResourceAsStream("classifier/test-classifier.csv")!!.readBytes()

  @Test
  fun `canParse should return true for csv files`() {
    assertTrue { parser.canParse("test.csv") }
  }

  @Test
  fun `parse should return correct headers`() {
    val file = parser.parse(testFile)
    assertEquals(listOf("pattern", "categoryFiftyThirtyTwenty", "categoryDetailed", "comment"), file.headers)
  }

  @Test
  fun `parse should return correct rows`() {
    val file = parser.parse(testFile)
    val expectedRows = listOf(
      mapOf("pattern" to "(B|b)olt", "categoryFiftyThirtyTwenty" to "wants",
        "categoryDetailed" to "eatout", "comment" to ""),
      mapOf("pattern" to "(PRISMA|Prisma)", "categoryFiftyThirtyTwenty" to "needs",
        "categoryDetailed" to "groceries", "comment" to ""),
      mapOf("pattern" to "(RIMI|Rimi|rimi)", "categoryFiftyThirtyTwenty" to "needs",
        "categoryDetailed" to "groceries", "comment" to "rimi comment")
    )
    assertEquals(expectedRows, file.rows)
  }
}
