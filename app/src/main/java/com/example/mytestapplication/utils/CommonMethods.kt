package com.example.kotlinroomdemo.Utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mytestapplication.application.MyApplication
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object CommonMethods {

    val CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE"
    val date_fomatter_DD_MMM_YYYY_H_MM = "dd-MMM-yyyy h:mm: a" //14-Jul-2017 10:37 AM
    private val DATE_FORMT = "MM-dd-yyyy"


    fun isOnline(context: Context):Boolean{
        var connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var capability = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return capability?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
    }

    fun getDate(milliSeconds: Long, dateFormat: String?): String? {
        // Create a DateFormatter object for displaying date in specified format.
        val formatter = SimpleDateFormat(dateFormat)
        //formatter.setTimeZone(TimeZone.getTimeZone("IST"));

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return formatter.format(calendar.time)
    }

    fun getAppVersionName(): String {
        val manager: PackageManager = MyApplication.context.getPackageManager()
        var info: PackageInfo? = null
        try {
            info = manager.getPackageInfo(
                MyApplication.context.getPackageName(), 0
            )
        } catch (e: PackageManager.NameNotFoundException) {
            //e.printStackTrace()
        }
        return info!!.versionName
    }

    fun getOSdetail(): String {
        val release = Build.VERSION.RELEASE
        val sdkVersion = Build.VERSION.SDK_INT
        return "Android SDK: $sdkVersion ($release)"
    }

    open fun showToast(applicationContext: Context, msg: String){
        val myToast = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT)
        myToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        myToast.show()
    }

    fun convertTODate(strdate: String?, date_format:String,output_date_format:String): String? {
        val inputFormat = SimpleDateFormat(date_format)
        val outputFormat: DateFormat = SimpleDateFormat(output_date_format) // 20
        // inputFormat.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));

        var date: Date? = null
        var str: String? = null
        try {
            date = inputFormat.parse(strdate)
            str = outputFormat.format(date)
        } catch (e: ParseException) {
            //e.printStackTrace()
        }
        return str
    }

    @Throws(ParseException::class)
    fun formatDateStr(strDate: String?): String? {
        val inputFormatter: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        inputFormatter.setTimeZone(TimeZone.getTimeZone("UTC"))
        val outputFormatter: DateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
        return outputFormatter.format(inputFormatter.parse(strDate))
    }
}