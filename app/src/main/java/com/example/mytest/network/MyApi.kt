package com.example.mytest.network

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("auth/status")
    suspend fun userStatus(
        @Field("userId") userId: Long
    ): MyResponse

}