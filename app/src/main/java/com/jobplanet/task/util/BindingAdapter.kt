package com.jobplanet.task.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jobplanet.task.R
import com.jobplanet.task.main.MainAdapter
import com.jobplanet.task.model.JobPlanetModel

object BindingAdapter {

    @BindingAdapter("listData")
    @JvmStatic
    fun bindData(recyclerView: RecyclerView, data: List<JobPlanetModel>?) {

        val adapter = recyclerView.adapter as MainAdapter
        adapter.submitList(data)
    }

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String?) {

//        Glide.with(imageView.context).load(url)
//            .error(R.drawable.ic_launcher_background)
//            .into(imageView)
    }
}