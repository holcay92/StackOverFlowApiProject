package com.devtides.stackoverflowquery.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//
interface StackOverFlowApi {
    @GET("/2.3/questions?order=desc&sort=activity&tagged=android&site=stackoverflow")
    fun getQuestions(@Query("page") page:Int): Call<ResponseWrapper<Question>>

    @GET("/2.3/questions/{id}/answers?order=desc&sort=activity&site=stackoverflow")
    fun getAnswers(@Path("id") questionid:Int,@Query("page") page: Int): Call<ResponseWrapper<Answer>>
}