package com.wutsi.marketplace.manager

import com.wutsi.marketplace.manager.dto.AddPictureRequest
import com.wutsi.marketplace.manager.dto.AddPictureResponse
import com.wutsi.marketplace.manager.dto.CreateProductRequest
import com.wutsi.marketplace.manager.dto.CreateProductResponse
import com.wutsi.marketplace.manager.dto.EnableStoreResponse
import com.wutsi.marketplace.manager.dto.GetProductResponse
import com.wutsi.marketplace.manager.dto.ImportProductRequest
import com.wutsi.marketplace.manager.dto.SearchProductRequest
import com.wutsi.marketplace.manager.dto.SearchProductResponse
import com.wutsi.marketplace.manager.dto.UpdateProductAttributeListRequest
import feign.Headers
import feign.Param
import feign.RequestLine
import kotlin.Long
import kotlin.String
import kotlin.Unit

public interface MarketplaceManagerApi {
  @RequestLine("POST /v1/stores")
  @Headers(value=["Content-Type: application/json"])
  public fun enableStore(): EnableStoreResponse

  @RequestLine("DELETE /v1/stores")
  @Headers(value=["Content-Type: application/json"])
  public fun suspendStore(): Unit

  @RequestLine("POST /v1/products")
  @Headers(value=["Content-Type: application/json"])
  public fun createProduct(request: CreateProductRequest): CreateProductResponse

  @RequestLine("POST /v1/products/attributes")
  @Headers(value=["Content-Type: application/json"])
  public fun updateProductAttribute(request: UpdateProductAttributeListRequest): Unit

  @RequestLine("POST /v1/products/{id}/publish")
  @Headers(value=["Content-Type: application/json"])
  public fun publishProduct(@Param("id") id: Long): Unit

  @RequestLine("POST /v1/products/{id}/unpublish")
  @Headers(value=["Content-Type: application/json"])
  public fun unpublishProduct(@Param("id") id: Long): Unit

  @RequestLine("POST /v1/products/import")
  @Headers(value=["Content-Type: application/json"])
  public fun importProduct(request: ImportProductRequest): Unit

  @RequestLine("POST /v1/products/search")
  @Headers(value=["Content-Type: application/json"])
  public fun searchProduct(request: SearchProductRequest): SearchProductResponse

  @RequestLine("GET /v1/products/{id}")
  @Headers(value=["Content-Type: application/json"])
  public fun getProduct(@Param("id") id: Long): GetProductResponse

  @RequestLine("POST /v1/pictures")
  @Headers(value=["Content-Type: application/json"])
  public fun addPicture(request: AddPictureRequest): AddPictureResponse

  @RequestLine("DELETE /v1/pictures/{id}")
  @Headers(value=["Content-Type: application/json"])
  public fun deletePicture(@Param("id") id: Long): Unit

  @RequestLine("GET /v1/categories/import?language={language}")
  @Headers(value=["Content-Type: application/json"])
  public fun importCategory(@Param("language") language: String): Unit
}
