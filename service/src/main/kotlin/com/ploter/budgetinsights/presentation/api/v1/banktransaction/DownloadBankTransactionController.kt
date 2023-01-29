package com.ploter.budgetinsights.presentation.api.v1.banktransaction

import com.ploter.budgetinsights.application.banktransaction.SearchBankTransaction
import com.ploter.budgetinsights.application.banktransaction.command.SearchBankTransactionCommand
import com.ploter.budgetinsights.presentation.api.v1.banktransaction.transformer.BankTransactionTransformer
import com.ploter.budgetinsights.v1.banktransaction.BankTransactionResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletResponse

@Controller
class DownloadBankTransactionController(
  val application: SearchBankTransaction
) {

  private val transformer = BankTransactionTransformer()

  @ResponseBody
  @RequestMapping("/transactions",
    method = [RequestMethod.POST],
    consumes = [MediaType.APPLICATION_JSON_VALUE],
    produces = ["text/csv;charset=UTF-8"]
  )
  fun download(httpServletResponse: HttpServletResponse): BankTransactionResponse {
    val bankTransactionResponse = application.execute(SearchBankTransactionCommand()) { t -> transformer.convert(t) }
    httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"Bank-transactions.csv\"")
    return bankTransactionResponse
  }

}