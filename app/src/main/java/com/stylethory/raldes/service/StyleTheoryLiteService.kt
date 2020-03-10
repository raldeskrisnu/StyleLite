package com.stylethory.raldes.service

import com.stylethory.raldes.model.ColorsResponse
import com.stylethory.raldes.model.ProductResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface StyleTheoryLiteService {

    @GET("/v3/products")
    fun getProducts(@Query("per_page") perPage:Int, @Query("page_number") pageNumber:Int): Observable<ProductResponse>

    @GET("/v1/colors")
    fun getColors(): Observable<ColorsResponse>
}