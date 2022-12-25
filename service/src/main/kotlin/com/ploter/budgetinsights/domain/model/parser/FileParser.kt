package com.ploter.budgetinsights.domain.model.parser

interface FileParser {

  fun canParse(fileName: String): Boolean

  fun parse(content: ByteArray): File

}