package com.wutsi.marketplace.manager

import com.wutsi.marketplace.manager.dto.ActivateStoreResponse
import com.wutsi.marketplace.manager.dto.CreateDiscountRequest
import com.wutsi.marketplace.manager.dto.CreateDiscountResponse
import com.wutsi.marketplace.manager.dto.CreateFileRequest
import com.wutsi.marketplace.manager.dto.CreateFileResponse
import com.wutsi.marketplace.manager.dto.CreatePictureRequest
import com.wutsi.marketplace.manager.dto.CreatePictureResponse
import com.wutsi.marketplace.manager.dto.CreateProductRequest
import com.wutsi.marketplace.manager.dto.CreateProductResponse
import com.wutsi.marketplace.manager.dto.GetDiscountResponse
import com.wutsi.marketplace.manager.dto.GetProductResponse
import com.wutsi.marketplace.manager.dto.GetStoreResponse
import com.wutsi.marketplace.manager.dto.ImportProductRequest
import com.wutsi.marketplace.manager.dto.SearchDiscountRequest
import com.wutsi.marketplace.manager.dto.SearchDiscountResponse
import com.wutsi.marketplace.manager.dto.SearchMeetingProviderResponse
import com.wutsi.marketplace.manager.dto.SearchProductRequest
import com.wutsi.marketplace.manager.dto.SearchProductResponse
import com.wutsi.marketplace.manager.dto.UpdateDiscountAttributeRequest
import com.wutsi.marketplace.manager.dto.UpdateProductAttributeListRequest
import com.wutsi.marketplace.manager.dto.UpdateProductEventRequest
import feign.Headers
import feign.Param
import feign.RequestLine
import kotlin.Long
import kotlin.String
import kotlin.Unit

public interface MarketplaceManagerApi {
  @RequestLine("POST /v1/stores")
  @Headers(value=["Content-Type: application/json"])
  public fun activateStore(): ActivateStoreResponse

  @RequestLine("DELETE /v1/stores")
  @Headers(value=["Content-Type: application/json"])
  public fun deactivateStore(): Unit

  @RequestLine("GET /v1/stores/{id}")
  @Headers(value=["Content-Type: application/json"])
  public fun getStore(@Param("id") id: Long): GetStoreResponse

  @RequestLine("POST /v1/meeting-providers/search")
  @Headers(value=["Content-Type: application/json"])
  public fun searchMeetingProvider(): SearchMeetingProviderResponse

  @RequestLine("POST /v1/products")
  @Headers(value=["Content-Type: application/json"])
  public fun createProduct(request: CreateProductRequest): CreateProductResponse

  @RequestLine("POST /v1/products/attributes")
  @Headers(value=["Content-Type: application/json"])
  public fun updateProductAttribute(request: UpdateProductAttributeListRequest): Unit

  @RequestLine("POST /v1/files")
  @Headers(value=["Content-Type: application/json"])
  public fun createFile(request: CreateFileRequest): CreateFileResponse

  @RequestLine("DELETE /v1/files/{id}")
  @Headers(value=["Content-Type: application/json"])
  public fun deleteFile(@Param("id") id: Long): Unit

  @RequestLine("POST /v1/products/{id}/publish")
  @Headers(value=["Content-Type: application/json"])
  public fun publishProduct(@Param("id") id: Long): Unit

  @RequestLine("POST /v1/products/{id}/unpublish")
  @Headers(value=["Content-Type: application/json"])
  public fun unpublishProduct(@Param("id") id: Long): Unit

  @RequestLine("POST /v1/products/event")
  @Headers(value=["Content-Type: application/json"])
  public fun updateProductEvent(request: UpdateProductEventRequest): Unit

  @RequestLine("POST /v1/products/import")
  @Headers(value=["Content-Type: application/json"])
  public fun importProduct(request: ImportProductRequest): Unit

  @RequestLine("POST /v1/products/search")
  @Headers(value=["Content-Type: application/json"])
  public fun searchProduct(request: SearchProductRequest): SearchProductResponse

  @RequestLine("GET /v1/products/{id}")
  @Headers(value=["Content-Type: application/json"])
  public fun getProduct(@Param("id") id: Long): GetProductResponse

  @RequestLine("DELETE /v1/products/{id}")
  @Headers(value=["Content-Type: application/json"])
  public fun deleteProduct(@Param("id") id: Long): Unit

  @RequestLine("POST /v1/pictures")
  @Headers(value=["Content-Type: application/json"])
  public fun createPicture(request: CreatePictureRequest): CreatePictureResponse

  @RequestLine("DELETE /v1/pictures/{id}")
  @Headers(value=["Content-Type: application/json"])
  public fun deletePicture(@Param("id") id: Long): Unit

  @RequestLine("GET /v1/categories/import?language={language}")
  @Headers(value=["Content-Type: application/json"])
  public fun importCategory(@Param("language") language: String): Unit

  @RequestLine("POST /v1/discounts")
  @Headers(value=["Content-Type: application/json"])
  public fun createDiscount(request: CreateDiscountRequest): CreateDiscountResponse

  @RequestLine("GET /v1/discounts/{id}")
  @Headers(value=["Content-Type: application/json"])
  public fun getDiscount(@Param("id") id: Long): GetDiscountResponse

  @RequestLine("DELETE /v1/discounts/{id}")
  @Headers(value=["Content-Type: application/json"])
  public fun deleteDiscount(@Param("id") id: Long): Unit

  @RequestLine("POST /v1/discounts/{id}/attributes")
  @Headers(value=["Content-Type: application/json"])
  public fun updateDiscountAttribute(@Param("id") id: Long,
      request: UpdateDiscountAttributeRequest): Unit

  @RequestLine("POST /v1/discounts/search")
  @Headers(value=["Content-Type: application/json"])
  public fun searchDiscount(request: SearchDiscountRequest): SearchDiscountResponse

  @RequestLine("POST /v1/discounts/{discount-id}/products/{product-id}")
  @Headers(value=["Content-Type: application/json"])
  public fun addDiscountProduct(@Param("discount-id") discountId: Long, @Param("product-id")
      productId: Long): Unit

  @RequestLine("DELETE /v1/discounts/{discount-id}/products/{product-id}")
  @Headers(value=["Content-Type: application/json"])
  public fun removeDiscountProduct(@Param("discount-id") discountId: Long, @Param("product-id")
      productId: Long): Unit
}
