package com.example.mytestapplication.network

import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import com.example.kotlinroomdemo.Utils.CommonMethods
import com.example.mytestapplication.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sallon.bookmeeasy.Utils.AppConstant
import okhttp3.ConnectionPool
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStream
import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.*
import kotlin.collections.HashMap


class ApiManager {

    companion object networkAccess {
        // Urls
       var baseUrl: String = "https://api.github.com/"

        val specs = listOf(ConnectionSpec.CLEARTEXT, ConnectionSpec.MODERN_TLS)

        var tlsSpecs: List<*> = Arrays.asList(ConnectionSpec.MODERN_TLS,ConnectionSpec.CLEARTEXT)

        fun getApi(): RetrofitApi {
          /*  val okHttpClient = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()*/
            val gson = GsonBuilder()
                .setLenient()
                .create()
          //  val interceptor = HttpLoggingInterceptor()
           // interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                     .connectionSpecs(specs)
                   // .protocols(listOf(Protocol.HTTP_2))
                    .readTimeout(5, TimeUnit.MINUTES)
                .connectTimeout(5, TimeUnit.MINUTES)
                   .addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                //.client(okHttpClient2())
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            // prepare call in Retrofit 2.0
            return retrofit.create<RetrofitApi>(RetrofitApi::class.java)
        }


        fun getHeaderMap(isTokenRequired: Boolean, token: String): Map<String, String> {
            val headerMap: MutableMap<String, String> =
                HashMap()
            if (isTokenRequired && token != null) {
               // headerMap["Authorization"] = token
                headerMap["Authorization"] = "Bearer "+ token

            }
            headerMap["Content-Type"] = "application/json"
           // headerMap["appkey"] = AppConstant.AppKey
            headerMap["devicename"] = Build.MANUFACTURER + " - " + Build.MODEL
            headerMap["os"] = CommonMethods.getOSdetail()
            headerMap["apptype"] = AppConstant.AppType
            headerMap["appversion"] = CommonMethods.getAppVersionName()
          //  headerMap["deviceToken"] = CommonMethods.getFcmDeviceToken()//"sdefer33"  // set firebase deviceID

            return headerMap
        }


        fun getHeaderforMultipartMap(isTokenRequired: Boolean, token: String): Map<String, String> {
            val headerMap: MutableMap<String, String> =
                HashMap()
            if (isTokenRequired && token != null) {
                // headerMap["Authorization"] = token
                headerMap["Authorization"] = "Bearer "+ token

            }
          //  headerMap["Content-Type"] = "multipart/form-data"
              return headerMap
        }


        fun getWithoutHeaderMap(): Map<String, String> {
            val headerMap: MutableMap<String, String> =
                   HashMap()
            headerMap["Content-Type"] = "application/json"
            return headerMap
        }


        fun <T> callback(fn: (Throwable?, Response<T>?) -> Unit): Callback<T> {
            return object : Callback<T> {
                override fun onResponse(call: Call<T>, response: retrofit2.Response<T>) = fn(null, response)
                override fun onFailure(call: Call<T>, t: Throwable) = fn(t, null)
            }
        }


        //Without SSL
        private fun okHttpClient2(): OkHttpClient {
            return try {
                // Create a trust manager that does not validate certificate chains
                val trustAllCerts =
                    arrayOf<TrustManager>(
                        object : X509TrustManager {
                            @Throws(CertificateException::class)
                            override fun checkClientTrusted(
                                chain: Array<X509Certificate>,
                                authType: String
                            ) {
                            }

                            @Throws(CertificateException::class)
                            override fun checkServerTrusted(
                                chain: Array<X509Certificate>,
                                authType: String
                            ) {
                            }

                            override fun getAcceptedIssuers(): Array<X509Certificate> {
                                return arrayOf()
                            }
                        }
                    )
                // Install the all-trusting trust manager
                val sslContext =
                    SSLContext.getInstance("SSL")
                sslContext.init(null, trustAllCerts, SecureRandom())
                // Create an ssl socket factory with our all-trusting manager
                val sslSocketFactory = sslContext.socketFactory

                val builder = OkHttpClient.Builder()
                builder.addNetworkInterceptor(interceptor)
                builder.sslSocketFactory(
                    sslSocketFactory,
                    trustAllCerts[0] as X509TrustManager
                )
                builder.hostnameVerifier { hostname, session -> true }
                builder.build()
            } catch (e: Exception) {
                Log.e(TAG, "okHttpClient2: ${e.message}")
                throw RuntimeException(e)
            }
        }

        private val interceptor = run {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.apply {
                if (BuildConfig.DEBUG) {
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                }else {
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
                }
            }
        }

    }






}