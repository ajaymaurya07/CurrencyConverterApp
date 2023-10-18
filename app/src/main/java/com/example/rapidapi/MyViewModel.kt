package com.example.rapidapi

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rapidapi.repository.MyRepository

class MyViewModel(var context: Context) :ViewModel() {

    var myRepository = MyRepository()
    var isloading :MutableLiveData<Boolean> =myRepository.isLoading
    var isConverting :MutableLiveData<Boolean> = myRepository.isExchanging

    var sharedPreferences=context.getSharedPreferences("data",Context.MODE_PRIVATE)
    var editor=sharedPreferences.edit()

//    ["SGD","MYR","EUR","USD","AUD","JPY","CNH","HKD","CAD","INR","DKK","GBP","RUB","NZD","MXN","IDR","IDR","THB","VND"]

    fun getCurrency(): MutableLiveData<MutableList<String>> {
        var temp =  myRepository.getCurrencyList()

            editor.putString("SGD", "SGD")
            editor.putString("MYR", "MYR")
            editor.putString("EUR", "EUR")
            editor.putString("USD", "USD")
            editor.putString("AUD", "AUD")
            editor.putString("JPY", "JPY")
            editor.putString("CNH", "CNH")
            editor.putString("HKD", "HKD")
            editor.putString("CAD", "CAD")
            editor.putString("INR", "INR")
            editor.putString("DKK", "DKK")
            editor.putString("GBP", "GBP")
            editor.putString("RUB", "RUB")
            editor.putString("NZD", "NZD")
            editor.putString("MXN", "MXN")
            editor.putString("IDR", "IDR")
            editor.putString("THB", "THB")
            editor.putString("VND", "VND")
            editor.putBoolean("check", true)
            editor.apply()
            return temp


    }

    fun temp():MutableList<String>{
        var list: MutableList<String> = mutableListOf()

        list.add(sharedPreferences.getString("SGD", "")!!)
        list.add(sharedPreferences.getString("MYR", "")!!)
        list.add(sharedPreferences.getString("EUR", "")!!)
        list.add(sharedPreferences.getString("USD", "")!!)
        list.add(sharedPreferences.getString("USD", "")!!)
        list.add(sharedPreferences.getString("AUD", "")!!)
        list.add(sharedPreferences.getString("JPY", "")!!)
        list.add(sharedPreferences.getString("CNH", "")!!)
        list.add(sharedPreferences.getString("HKD", "")!!)
        list.add(sharedPreferences.getString("CAD", "")!!)
        list.add(sharedPreferences.getString("INR", "")!!)
        list.add(sharedPreferences.getString("DKK", "")!!)
        list.add(sharedPreferences.getString("GBP", "")!!)
        list.add(sharedPreferences.getString("RUB", "")!!)
        list.add(sharedPreferences.getString("NZD", "")!!)
        list.add(sharedPreferences.getString("MXN", "")!!)
        list.add(sharedPreferences.getString("IDR", "")!!)
        list.add(sharedPreferences.getString("THB", "")!!)
        list.add(sharedPreferences.getString("VND", "")!!)


        return list
    }

    fun getExchangeData(from: String, to: String, quantity: Double) : MutableLiveData<Double>{
        return myRepository.exchangedCurrency(from, to, quantity)
    }
}