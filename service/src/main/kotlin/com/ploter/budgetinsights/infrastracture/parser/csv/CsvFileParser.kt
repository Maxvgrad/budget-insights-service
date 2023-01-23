package com.ploter.budgetinsights.infrastracture.parser.csv

import com.ploter.budgetinsights.domain.model.parser.File
import com.ploter.budgetinsights.domain.model.parser.FileParser
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.io.input.BOMInputStream
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

class CsvFileParser : FileParser {
  override fun canParse(fileName: String) = fileName.endsWith("csv", true)

  override fun parse(content: ByteArray): File {
    val csvFormat = CSVFormat.Builder.create()
      .setHeader()
      .setAllowMissingColumnNames(true)
      .setSkipHeaderRecord(true)
      .setIgnoreSurroundingSpaces(true)
      .build()
    val inputStream = BOMInputStream(ByteArrayInputStream(content))
    InputStreamReader(inputStream, StandardCharsets.UTF_8).use {reader ->
      CSVParser(reader, csvFormat).use { parser ->
        val headers = parser.headerNames
        val rows = parser.map { record ->
          headers.associateWith { h ->
            record.get(h)
          }
        }
        return File(
          headers = headers,
          rows = rows
        )
      }
    }
  }
}