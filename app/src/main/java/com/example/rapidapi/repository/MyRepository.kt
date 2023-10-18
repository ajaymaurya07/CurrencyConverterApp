package com.example.rapidapi.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.rapidapi.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyRepository {

//    var  apiKey = "b4041c4535mshcbb8e8b2795a8a8p1b2e92jsnd8cce635fce7"
//    var host = "currency-exchange.p.rapidapi.com"

    var currencyDataList = MutableLiveData<MutableList<String>>()
    var exchangeData = MutableLiveData<Double>()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply {
        value = true
    }
    var isExchanging: MutableLiveData<Boolean> = MutableLiveData<Boolean>()



    fun getCurrencyList(): MutableLiveData<MutableList<String>> {
        var call = RetrofitClient.apiCall.getCurrencyList(/*apiKey, host*/)

        call.enqueue(object : Callback<MutableList<String>> {
            override fun onResponse(
                call: Call<MutableList<String>>,
                response: Response<MutableList<String>>
            ) {
                if (response.isSuccessful) {
                    currencyDataList.value = response.body()
                    isLoading.value = false
                } else {
                    Log.d("datasize1", "onResponsecode: ${response.code()} ")
                }
            }

            override fun onFailure(call: Call<MutableList<String>>, t: Throwable) {
                Log.d("datasize1", "onResponse Cause: ${t.cause} ")
                Log.d("datasize1", "onResponse message: ${t.message} ")
            }
        })
        return currencyDataList
    }

    fun exchangedCurrency(from: String, to: String, quantity: Double): MutableLiveData<Double> {
        var call = RetrofitClient.apiCall.getConvertResult(from, to, quantity)

        call.enqueue(object : Callback<Double> {
            override fun onResponse(call: Call<Double>, response: Response<Double>) {
                if (response.isSuccessful) {
                    exchangeData.value = response.body()
                    isExchanging.value = false
                } else {

                }
            }

            override fun onFailure(call: Call<Double>, t: Throwable) {

            }

        })
        return exchangeData
    }


}