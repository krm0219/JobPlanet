package com.jobplanet.task.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jobplanet.task.model.JobPlanetModel

class DetailViewModel : ViewModel() {

    private val _item = MutableLiveData<JobPlanetModel>()
    val item: MutableLiveData<JobPlanetModel>
        get() = _item
}