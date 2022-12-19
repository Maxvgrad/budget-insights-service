package com.ploter.budgetinsights.domain.model.importgroup

@JvmInline
value class ImportSourceId(private val value: Long) {
    companion object {
        fun newInstance(): ImportSourceId {
            return ImportSourceId(3)
        }
    }
}