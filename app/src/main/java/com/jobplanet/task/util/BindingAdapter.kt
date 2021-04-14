package com.jobplanet.task.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jobplanet.task.R
import com.jobplanet.task.main.ThemeAdapter
import com.jobplanet.task.model.ThemeModel

object BindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String?) {

        Glide.with(imageView.context).load(url)
            .error(R.drawable.ic_launcher_background)
            .into(imageView)
    }

    @BindingAdapter("themesData")
    @JvmStatic
    fun bindThemeData(recyclerView: RecyclerView, data: List<ThemeModel>?) {

        val adapter = recyclerView.adapter as ThemeAdapter
        adapter.submitList(data)
    }
}