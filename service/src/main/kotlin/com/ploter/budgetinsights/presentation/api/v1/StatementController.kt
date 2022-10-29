package com.ploter.budgetinsights.presentation.api.v1

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Controller
class StatementController {

    @RequestMapping("/statements", method = [RequestMethod.POST])
    fun upload(): String {
        println("CONTROLLER!!!!")
        return "index2"
    }
}