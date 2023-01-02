package com.wutsi.marketplace.manager.dto

import java.time.LocalDate
import kotlin.Boolean
import kotlin.Int
import kotlin.String

public data class UpdateDiscountRequest(
  public val name: String = "",
  public val rate: Int = 0,
  public val starts: LocalDate = LocalDate.now(),
  public val ends: LocalDate = LocalDate.now(),
  public val allProducts: Boolean = false,
)
