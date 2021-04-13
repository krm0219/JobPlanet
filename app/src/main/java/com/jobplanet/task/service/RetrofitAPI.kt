package com.jobplanet.task.service

import com.jobplanet.task.model.ItemsModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {

    @GET("test_data.json")
    fun getTestData(): Single<ItemsModel>
}