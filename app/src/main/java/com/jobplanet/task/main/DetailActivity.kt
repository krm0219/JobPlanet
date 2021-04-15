package com.jobplanet.task.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.jobplanet.task.R
import com.jobplanet.task.databinding.ActivityDetailBinding
import com.jobplanet.task.model.JobPlanetModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        val item = intent.getSerializableExtra("item") as JobPlanetModel
        viewModel.item.value = item


        viewModel.item.observe(this, Observer {

            if (it.cellType.contains("COMPANY")) {

                layout_detail_company.visibility = View.VISIBLE
                layout_detail_review.visibility = View.GONE
            } else {

                layout_detail_company.visibility = View.GONE
                layout_detail_review.visibility = View.VISIBLE
            }
        })

    }
}