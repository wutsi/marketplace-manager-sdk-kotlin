package com.wutsi.marketplace.manager.dto

import kotlin.Long
import kotlin.String

public data class AddPictureRequest(
  public val productId: Long = 0,
  public val url: String = "",
)
