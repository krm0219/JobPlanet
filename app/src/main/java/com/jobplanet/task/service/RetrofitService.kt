package com.jobplanet.task.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private const val URL = "https://jpassets.jobplanet.co.kr/mobile-config/"

    private fun getClient(url: String): Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(OkHttpClient())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val client: RetrofitAPI = getClient(URL).create(RetrofitAPI::class.java)
}