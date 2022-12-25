package com.ploter.budgetinsights.infrastracture.persistence.importgroup

import com.ploter.budgetinsights.domain.model.importgroup.*

class PersistentImportGroupFactory(
  private val importGroupSequence: ImportGroupSequence
) : ImportGroupFactory {

  override fun create(importSourceId: ImportSourceId, importSourceType: ImportSourceType): ImportGroup {
    return ImportGroup(
      id = importGroupSequence.nextVal(),
      importSourceId = importSourceId,
      importSourceType = importSourceType
    )
  }
}