package com.ploter.budgetinsights.application.bankstatement

import com.ploter.budgetinsights.application.bankstatement.command.UploadBankStatementCommand
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatement
import java.util.function.Function

class UploadBankStatement {

    fun <T> execute(command: UploadBankStatementCommand, transformer: Function<BankStatement, T>): T {
        return transformer.apply(BankStatement(command.fileName))
    }

}