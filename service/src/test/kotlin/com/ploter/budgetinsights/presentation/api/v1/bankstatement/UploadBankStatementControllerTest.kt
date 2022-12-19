package com.ploter.budgetinsights.presentation.api.v1.bankstatement

import com.ploter.budgetinsights.test.BaseWebLayerTest
import org.springframework.test.web.servlet.multipart
import kotlin.test.Test

class UploadBankStatementControllerTest: BaseWebLayerTest() {

    @Test
    fun test() {
        val fileName = "/statement/csv/LHV_Account_Statement_2022-12-17.csv"
        val fileBytes = this.javaClass.getResourceAsStream(fileName).use { it!!.readBytes() }

        mockMvc.multipart("/statements") {
            file("file", fileBytes)
        }
                .andExpect {
            status { isOk() }
        }
    }

}
// add MockK