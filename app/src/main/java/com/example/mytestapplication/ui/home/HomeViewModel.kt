package com.example.mytestapplication.ui.home

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinroomdemo.Utils.AppLogger
import com.example.mytestapplication.model.response.issues_response.IssuesResponseAll
import com.example.mytestapplication.network.ApiManager
import com.google.gson.Gson
import retrofit2.Call

class HomeViewModel (application: Application): AndroidViewModel(Application()) {
    private var context: Context
    init {
        context = application.baseContext
    }
    var getList_MutableLiveResponse: MutableLiveData<List<IssuesResponseAll>> = MutableLiveData()

    var getErrorStringLiveData: MutableLiveData<String> = MutableLiveData()


    fun getIssuesList() {

        var call: Call<List<IssuesResponseAll>> = ApiManager.getApi().getList(
            ApiManager.getWithoutHeaderMap()
        )

        call.enqueue(ApiManager.callback { throwable, response ->
            var myResponse: List<IssuesResponseAll>
            response?.body()?.toString()?.let { AppLogger.errorLogs("ListResponse", it) }

            if (response != null && response?.isSuccessful!!) {
                myResponse = response?.body()!!

                Log.d("APIresponse", "success");

                getList_MutableLiveResponse.postValue(myResponse)
            } else {
                if (response != null && response.code() == 200) {
                    val error_message: IssuesResponseAll = Gson().fromJson(response?.errorBody()!!.charStream(),
                        IssuesResponseAll::class.java
                    )
                   // getErrorStringLiveData.postValue(error_message.issuesResponseAll?.get(0)?.body!!)
                }
            }



        })

    }

}