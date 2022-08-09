package com.example.mytestapplication

import android.util.Log
import com.example.kotlinroomdemo.Utils.AppLogger
import com.example.mytestapplication.model.response.issues_response.IssuesResponseAll
import com.example.mytestapplication.network.ApiManager
import com.example.mytestapplication.network.RetrofitApi
import com.example.mytestapplication.ui.home.HomeViewModel
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call


@RunWith(MockitoJUnitRunner::class)
class ApiResponseTest {
    @Mock
    lateinit var mockviewmodel:RetrofitApi

    @Captor
    private val cb: ArgumentCaptor<List<IssuesResponseAll>>? = null

    @Before
    @Throws(Exception::class)
    public fun setUp() {
        MockitoAnnotations.openMocks(this)

    }

    @Test
    fun getApiList(){
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




}
