package com.ploter.budgetinsights.infrastracture.parser.csv

import com.ploter.budgetinsights.domain.model.parser.File
import com.ploter.budgetinsights.domain.model.parser.FileParser
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.io.input.BOMInputStream
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import java.io.Reader
import java.nio.charset.StandardCharsets

class CsvFileParser : FileParser {
  override fun canParse(fileName: String) = fileName.endsWith("csv", true)

  override fun parse(content: ByteArray): File {
    val csvFormat = CSVFormat.Builder.create()
      .setAllowMissingColumnNames(true)
      .setSkipHeaderRecord(true)
      .setIgnoreSurroundingSpaces(true)
      .build()
    val inputStream = BOMInputStream(ByteArrayInputStream(content))
    val reader: Reader = InputStreamReader(inputStream, StandardCharsets.UTF_8)
    val parser = CSVParser(reader, csvFormat)
    return File(
      headers = parser.headerNames,
      rows = parser.records.map { record -> parser.headerNames.associateWith { header -> record[header] } }
    )
  }
}