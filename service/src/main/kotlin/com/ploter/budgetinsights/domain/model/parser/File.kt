package com.ploter.budgetinsights.domain.model.parser

class File(
  val headers: List<String>,
  val rows: List<Map<String, String>>
)