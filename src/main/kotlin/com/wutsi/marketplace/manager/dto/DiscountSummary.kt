package com.wutsi.marketplace.manager.dto

import java.time.LocalDate
import java.time.OffsetDateTime
import kotlin.Int
import kotlin.Long
import kotlin.String

public data class DiscountSummary(
  public val id: Long = 0,
  public val storeId: Long = 0,
  public val name: String = "",
  public val rate: Int = 0,
  public val starts: LocalDate = LocalDate.now(),
  public val ends: LocalDate = LocalDate.now(),
  public val created: OffsetDateTime = OffsetDateTime.now(),
)
