package com.ploter.budgetinsights.domain.model

import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.temporal.ChronoUnit

@JvmInline
value class TimePoint
constructor(val value: Instant) {

  fun asOffsetDateTime(): OffsetDateTime {
    return value.atOffset(ZoneOffset.UTC)
  }

  companion object {
    fun newInstance(): TimePoint {
      return TimePoint(Instant.now().truncatedTo(ChronoUnit.MILLIS))
    }
  }
}