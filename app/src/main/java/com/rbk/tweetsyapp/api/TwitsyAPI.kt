package com.rbk.tweetsyapp.api

import com.rbk.tweetsyapp.models.CategoryResponse
import com.rbk.twitsyapp.models.TwitListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface TwitsyAPI {

    @GET("/v3/b/66ee92bdacd3cb34a88885ea?meta=false")
    suspend fun getCategories():Response<CategoryResponse>

    @GET("/v3/b/66ed92fdad19ca34f8a9a1c0?meta=false")
    suspend fun getTwits(@Header("X-JSON-Path")category: String): Response<List<TwitListItem>>
}