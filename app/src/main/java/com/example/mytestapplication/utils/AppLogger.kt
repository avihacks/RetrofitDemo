package com.example.kotlinroomdemo.Utils

import android.util.Log

object AppLogger {

    val islogger : Boolean = true

    fun errorLogs(text:String,textValue:String){
        if(islogger){
            Log.e(text,textValue)
        }
    }

    fun debugLogs(text:String,textValue:String){
        if(islogger){
            Log.d(text,textValue)
        }
    }

    fun errorLogs(isAlwaysShow:Boolean, text:String, textValue:String){
        if(isAlwaysShow){
            Log.e(text,textValue)
        }
    }


}