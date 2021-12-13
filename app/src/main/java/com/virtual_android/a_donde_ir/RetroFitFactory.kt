package com.virtual_android.a_donde_ir

import retrofit2.Retrofit

object RetroFitFactory {

    private const val BASE_URL = "https://my-json-server.typicode.com"

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()


    fun apiServices(): ApiServices = retrofit()
        .create(ApiServices::class.java)

    }