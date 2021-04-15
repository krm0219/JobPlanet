package com.jobplanet.task.main

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jobplanet.task.model.JobPlanetModel
import com.jobplanet.task.service.RetrofitService
import com.jobplanet.task.util.Event
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {

    private val _jobs = MutableLiveData<List<JobPlanetModel>>()
    val jobs = _jobs

    private val _progress = MutableLiveData<Int>()
    val progress: MutableLiveData<Int>
        get() = _progress

    private val _showErrorToast = MutableLiveData<Event<Boolean>>()
    val showErrorToast: MutableLiveData<Event<Boolean>>
        get() = _showErrorToast


    private val _item = MutableLiveData<JobPlanetModel>()
    val item: MutableLiveData<JobPlanetModel>
        get() = _item


    init {

        getData()
    }


    private fun getData() {

        RetrofitService.client.getTestData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                _progress.value = View.GONE
                _jobs.postValue(it.items)
            }, {

                _progress.value = View.GONE
                showErrorToast.value = Event(true)
            })
    }


    fun onClickCompany(item: JobPlanetModel) {

        Log.e("Company", "HERE onClickCompany")
        _item.value = item
    }

    fun onClickReview(item: JobPlanetModel) {

        Log.e("Review", "HERE onClickReview")
        _item.value = item
    }
}