package com.ploter.budgetinsights.domain.model.importgroup

interface ImportGroupRepository {
  fun save(group: ImportGroup)
}