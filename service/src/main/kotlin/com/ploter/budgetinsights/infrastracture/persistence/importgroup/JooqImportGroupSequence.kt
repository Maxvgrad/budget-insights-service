package com.ploter.budgetinsights.infrastracture.persistence.importgroup

import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupId
import com.ploter.budgetinsights.domain.model.importgroup.ImportGroupSequence
import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.Sequences.IMPORT_GROUP_ID_SEQ
import org.jooq.DSLContext

class JooqImportGroupSequence(
  private val dsl: DSLContext
) : ImportGroupSequence {
  override fun nextVal(): ImportGroupId {
    return ImportGroupId(dsl.nextval(IMPORT_GROUP_ID_SEQ).toLong())
  }
}