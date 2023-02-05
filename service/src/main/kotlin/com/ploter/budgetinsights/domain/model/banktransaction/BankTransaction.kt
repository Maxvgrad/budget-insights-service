package com.ploter.budgetinsights.domain.model.banktransaction;

import com.ploter.budgetinsights.domain.model.Amount
import com.ploter.budgetinsights.domain.model.DatePoint
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupId


// TODO: Add add account number
// TODO: Add add account number

class BankTransaction(
  val id: BankTransactionId,
  val importGroupId: ImportGroupId,
  val date: DatePoint,
  val amount: Amount,
  val currency: String,
  val description: String,
  val merchant: String,
  val reference: String,
  val account: String
) {

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is BankTransaction) return false

    if (id != other.id) return false
    if (importGroupId != other.importGroupId) return false
    if (date != other.date) return false
    if (amount != other.amount) return false
    if (currency != other.currency) return false
    if (description != other.description) return false
    if (merchant != other.merchant) return false
    if (reference != other.reference) return false
    if (account != other.account) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + importGroupId.hashCode()
    result = 31 * result + date.hashCode()
    result = 31 * result + amount.hashCode()
    result = 31 * result + currency.hashCode()
    result = 31 * result + description.hashCode()
    result = 31 * result + merchant.hashCode()
    result = 31 * result + reference.hashCode()
    result = 31 * result + account.hashCode()
    return result
  }

  override fun toString(): String {
    return "BankTransaction(id=$id, importGroupId=$importGroupId, date=$date, amount=$amount, currency='$currency')"
  }
}