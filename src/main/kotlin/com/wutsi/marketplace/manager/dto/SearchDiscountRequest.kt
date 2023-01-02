package com.wutsi.marketplace.manager.dto

import java.time.LocalDate
import kotlin.Int
import kotlin.Long
import kotlin.collections.List

public data class SearchDiscountRequest(
  public val storeId: Long = 0,
  public val productIds: List<Long> = emptyList(),
  public val date: LocalDate? = null,
  public val limit: Int = 100,
  public val offset: Int = 0,
)