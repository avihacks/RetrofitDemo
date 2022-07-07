package com.example.mytestapplication.network



import com.example.mytestapplication.model.response.issues_response.IssuesResponseAll
import retrofit2.Call
import retrofit2.http.*


interface RetrofitApi {

     @GET("repos/square/okhttp/issues")
    fun getList(
        @HeaderMap headers: Map<String, String>,
    ): Call<List<IssuesResponseAll>>



}