package com.example.mytest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApiClient {

    companion object{
        const val BASE_URL = ""
    }

    fun <T> buildApi(api: Class<T>): T{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

}