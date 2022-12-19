package com.ploter.budgetinsights.domain.model.importgroup

class ImportGroup(
        val id: ImportGroupId,
        val importSourceId: ImportSourceId,
        val importSourceType: ImportSourceType
)