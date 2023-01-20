package com.ploter.budgetinsights.infrastracture.persistence.importgroup

import com.ploter.budgetinsights.domain.model.importgroup.ImportGroup
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupFactory
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupSequence
import com.ploter.budgetinsights.domain.model.importgroup.ImportSourceId
import com.ploter.budgetinsights.domain.model.importgroup.ImportSourceType

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