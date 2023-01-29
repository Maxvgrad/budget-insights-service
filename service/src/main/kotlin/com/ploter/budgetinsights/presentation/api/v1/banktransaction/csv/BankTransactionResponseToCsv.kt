package com.ploter.budgetinsights.presentation.api.v1.banktransaction.csv

import com.ploter.budgetinsights.v1.banktransaction.BankTransactionResponse
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter
import java.io.StringWriter

fun BankTransactionResponse.toCsv(): ByteArray {
  val stringWriter = StringWriter()
  val csvPrinter = CSVPrinter(stringWriter, CSVFormat.EXCEL.builder()
    .setHeader(
      "Date",
      "Amount",
      "Currency",
      "Description",
      "Merchant",
      "Debit(Credit)",
      "Category",
      "Insight",
      "Comment")
    .build()
  )

  transactions.forEach { transaction ->
    csvPrinter.printRecord(
      transaction.date,
      transaction.amount,
      transaction.currency,
      transaction.description,
      transaction.merchant,
      transaction.debitOrCreditMethod,
      transaction.classification?.categoryFiftyThirtyTwenty,
      transaction.classification?.categoryDetailed,
      transaction.classification?.comment
    )
  }

  csvPrinter.flush()
  return stringWriter.toString().toByteArray()
}