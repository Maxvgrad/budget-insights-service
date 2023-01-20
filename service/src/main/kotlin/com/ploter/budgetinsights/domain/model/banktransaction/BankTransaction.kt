package com.ploter.budgetinsights.domain.model.banktransaction;

import com.ploter.budgetinsights.domain.model.TimePoint
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupId
import java.math.BigDecimal

class BankTransaction(
        val id: BankTransactionId,
        val importGroupId: ImportGroupId,
        val date: TimePoint,
        val amount: BigDecimal,
        val currency: String,
        val description: String,
        val merchant: String,
        val reference: String,
        val account: String
)