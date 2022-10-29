package com.ploter.budgetinsights.domain.model.transaction;

import java.math.BigDecimal;
import java.time.Instant;

class Transaction(
    val date: Instant,
    val amount: BigDecimal,
    val currency: String,
    val description: String,
    val merchant: String,
    val payment_reference: String,
    val account: String
)