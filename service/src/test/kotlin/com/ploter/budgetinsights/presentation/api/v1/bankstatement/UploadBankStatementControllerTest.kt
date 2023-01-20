package com.ploter.budgetinsights.presentation.api.v1.bankstatement

import com.ploter.budgetinsights.test.BaseWebLayerTest
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.web.servlet.multipart
import kotlin.test.Test


class UploadBankStatementControllerTest : BaseWebLayerTest() {

  @Test
  fun test() {
    val fileName = "/statement/csv/LHV_Account_Statement_2022-12-17.csv"
    val fileBytes = this.javaClass.getResourceAsStream(fileName).use { it!!.readBytes() }
    val file = MockMultipartFile("file", fileName.split("/").last(), "text/csv", fileBytes)

    mockMvc.multipart("/statements") {
      file(file)
    }
      .andExpect {
        status { isOk() }
      }
  }

}
// add MockK