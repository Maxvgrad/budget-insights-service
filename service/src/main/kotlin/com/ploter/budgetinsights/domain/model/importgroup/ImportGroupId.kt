package com.ploter.budgetinsights.domain.model.importgroup

@JvmInline
value class ImportGroupId(private val value: Long) {
    companion object {
        fun newInstance(): ImportGroupId {
            return ImportGroupId(3)
        }
    }
}