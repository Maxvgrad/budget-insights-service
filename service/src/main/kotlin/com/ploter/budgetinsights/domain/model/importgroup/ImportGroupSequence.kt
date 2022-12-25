package com.ploter.budgetinsights.domain.model.importgroup

interface ImportGroupSequence {

  fun nextVal(): ImportGroupId

}