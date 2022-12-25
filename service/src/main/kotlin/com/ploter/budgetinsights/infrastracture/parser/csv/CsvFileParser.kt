package com.ploter.budgetinsights.infrastracture.parser.csv

import com.ploter.budgetinsights.domain.model.parser.File
import com.ploter.budgetinsights.domain.model.parser.FileParser

class CsvFileParser : FileParser {
  override fun canParse(fileName: String) = fileName.endsWith("csv", true)

  override fun parse(content: ByteArray): File {
    TODO("Not yet implemented")
  }
}