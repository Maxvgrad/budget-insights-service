package com.ploter.budgetinsights.application.bankstatement.command

data class UploadBankStatementCommand(
        val fileName: String,
        val content: ByteArray
)