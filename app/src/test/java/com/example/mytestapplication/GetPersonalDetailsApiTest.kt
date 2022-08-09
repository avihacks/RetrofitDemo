package com.example.mytestapplication

import android.content.Context
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinroomdemo.Utils.AppLogger
import com.example.mytestapplication.application.MyApplication
import com.example.mytestapplication.model.response.issues_response.IssuesResponseAll
import com.example.mytestapplication.network.ApiManager
import com.example.mytestapplication.network.RetrofitApi
import com.example.mytestapplication.ui.home.HomeViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.junit.runners.JUnit4
import org.mockito.*
import org.mockito.Mockito.mock
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@RunWith(JUnit4::class)
class GetPersonalDetailsApiTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
   // private val server =  MockWebServer()
    var mMyApplication: MyApplication? = null


    private val gson = GsonBuilder()
        .setLenient()
        .create()
    @Before
    fun init() {
//        mMyApplication = mock(MyApplication::class.java)

        //server.start(8000)
       // var BASE_URL = server.url("/").toString()
        val okHttpClient = OkHttpClient
            .Builder()
            .build()
        val service = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiManager.baseUrl)
            .client(okHttpClient)
            .build().create(RetrofitApi::class.java)
       // repository = MainRepository(service)
    }
    @Test
    fun testApiSuccess() {

        var call: Call<List<IssuesResponseAll>> = ApiManager.getApi().getList(
            ApiManager.getWithoutHeaderMap()
        )

        call.enqueue(ApiManager.callback { throwable, response ->
            var myResponse: List<IssuesResponseAll>
            response?.body()?.toString()?.let { AppLogger.errorLogs("ListResponse", it) }

            if (response != null && response?.isSuccessful!!) {
                myResponse = response?.body()!!

                Assert.assertTrue(response.isSuccessful)

                Log.d("APIresponse", "success");

            } else {
                if (response != null && response.code() == 400) {
                    Assert.assertFalse(response.code() == 400)

                    // getErrorStringLiveData.postValue(error_message.issuesResponseAll?.get(0)?.body!!)
                }
            }



        })
    }
    @After
    fun tearDown() {

    }

}