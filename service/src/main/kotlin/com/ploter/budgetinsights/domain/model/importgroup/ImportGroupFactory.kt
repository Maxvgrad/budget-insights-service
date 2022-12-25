package com.ploter.budgetinsights.domain.model.importgroup

interface ImportGroupFactory {
  fun create(
    importSourceId: ImportSourceId,
    importSourceType: ImportSourceType
  ): ImportGroup
}