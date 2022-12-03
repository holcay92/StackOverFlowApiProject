package com.devtides.stackoverflowquery.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object StackOverFlowService {
// retrofit is a library that helps us to make network calls
// general structure of retrofit
    private val BASE_URL = "https://api.stackexchange.com/"

    val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(StackOverFlowApi::class.java)
}