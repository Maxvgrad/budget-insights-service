package com.ploter.budgetinsights.domain.model

import java.time.LocalDate
import java.time.format.DateTimeFormatter

@JvmInline
value class DatePoint
constructor(val value: LocalDate) {

  companion object {
    fun newInstance(): DatePoint {
      return DatePoint(LocalDate.now())
    }

    fun of(dateStr: String, pattern: String? = null): DatePoint {
      val formatter = if (pattern == null) {
        DateTimeFormatter.ISO_LOCAL_DATE
      } else {
        DateTimeFormatter.ofPattern(pattern)
      }
      return DatePoint(LocalDate.parse(dateStr, formatter))
    }
  }
}