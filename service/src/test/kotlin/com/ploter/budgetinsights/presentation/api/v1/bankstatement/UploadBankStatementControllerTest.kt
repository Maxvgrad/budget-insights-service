package com.ploter.budgetinsights.presentation.api.v1.bankstatement

import com.ploter.budgetinsights.test.BaseWebLayerTest
import org.springframework.test.web.servlet.multipart
import kotlin.test.Test

class UploadBankStatementControllerTest: BaseWebLayerTest() {

    @Test
    fun test() {
        mockMvc.multipart("/statements") {
            file("file", "ABC".toByteArray(charset("UTF8")))
        }
                .andExpect {
            status { isOk() }
        }
    }

}
// add MockK