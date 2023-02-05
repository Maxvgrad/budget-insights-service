package com.ploter.budgetinsights.infrastracture.banktransactionclassification

import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryDetailed
import com.ploter.budgetinsights.domain.model.banktransactionclassification.CategoryFiftyThirtyTwenty

data class ClassificationFile(
  val data: Map<Regex, Classification>
)

data class Classification(
  val data: Triple<CategoryFiftyThirtyTwenty, CategoryDetailed, String?>
)