package com.example.rapidapi.retrofit

import com.example.rapidapi.model.ApiMethods
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {
    var  apiKey = "b4041c4535mshcbb8e8b2795a8a8p1b2e92jsnd8cce635fce7"
    var host = "currency-exchange.p.rapidapi.com"
    private val retrofitClient : Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl("https://currency-exchange.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
//            .client(createOkHttpRequest(
//                apiKey,
//                host))
    }

    val apiCall : ApiMethods by lazy {
        retrofitClient.build().create(ApiMethods::class.java)
    }

//    private fun createOkHttpRequest(apiKey:String,apiHost:String):OkHttpClient{
//        val headerntercepter = Interceptor{chain ->
//               val request = chain.request()
//                   .newBuilder()
//                   .addHeader("X-RapidAPI-Key",apiKey)
//                   .addHeader("X-RapidAPI-Host",apiHost)
//                   .build()
//            chain.proceed(request)}
//        return OkHttpClient.Builder().addInterceptor(headerntercepter).build()
//        }
    }
