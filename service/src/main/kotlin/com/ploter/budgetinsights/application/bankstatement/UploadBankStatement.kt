package com.ploter.budgetinsights.application.bankstatement

import com.ploter.budgetinsights.application.bankstatement.command.UploadBankStatementCommand
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatement
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatementId
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import java.util.function.Function

class UploadBankStatement {

    fun <T> execute(command: UploadBankStatementCommand, transformer: Function<BankStatement, T>): T {
        val reader = InputStreamReader(ByteArrayInputStream(command.content), "UTF-8")
        val parser = CSVParser(reader, CSVFormat.DEFAULT)
        try {
            parser.records.forEach { record ->
                val date = record.get("Date")
                val amount = record.get("Amount")
                val currency = record.get("Currency")
                val description = record.get("Description")
                val merchant = record.get("Merchant")
                val reference = record.get("Reference")
                val account = record.get("Account")
            }
        } finally {
            parser.close()
            reader.close()
        }

        return transformer.apply(BankStatement(
                id = BankStatementId.newInstance(),
                fileName = command.fileName
        ))
    }

}