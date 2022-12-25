package com.ploter.budgetinsights.domain.model

import java.time.Instant
import java.time.temporal.ChronoUnit

@JvmInline
value class TimePoint
constructor(val value: Instant) {
    companion object {
        fun newInstance(): TimePoint {
            return TimePoint(Instant.now().truncatedTo(ChronoUnit.MILLIS))
        }
    }
}