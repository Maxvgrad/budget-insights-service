package com.ploter.budgetinsights.presentation.api.v1.bankstatement

import com.ploter.budgetinsights.application.bankstatement.UploadBankStatement
import com.ploter.budgetinsights.application.bankstatement.command.UploadBankStatementCommand
import com.ploter.budgetinsights.domain.model.bankstatement.BankStatement
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.multipart.MultipartFile
import java.util.function.Function

@Controller
class UploadBankStatementController(
    private val application: UploadBankStatement
) {

    @ResponseBody
    @RequestMapping("/statements",
            method = [RequestMethod.POST],
            consumes = [MediaType.MULTIPART_FORM_DATA_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun upload(@RequestParam("file") file: MultipartFile): BankStatement {
        return application.execute(UploadBankStatementCommand(file.originalFilename!!, file.bytes), Function.identity())
    }

}