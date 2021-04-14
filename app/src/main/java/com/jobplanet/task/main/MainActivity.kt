package com.jobplanet.task.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.jobplanet.task.R
import com.jobplanet.task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //   setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        setRecyclerView()
    }

    private fun setRecyclerView() {

        val adapter = MainAdapter()

        binding.recyclerMainList.adapter = adapter
        binding.recyclerMainList.setHasFixedSize(true)

        viewModel.jobs.observe(this, Observer {

            adapter.setData(it)
        })
    }


    /*

        // Toast Event
        viewModel.showEmptyToast.observe(viewLifecycleOwner, Observer {

            it.getContentIfNotHandled()?.let {

                Toast.makeText(activity, R.string.msg_empty_keyword, Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.showErrorToast.observe(viewLifecycleOwner, Observer {

            it.getContentIfNotHandled()?.let {

                Toast.makeText(activity, R.string.msg_error, Toast.LENGTH_SHORT).show()
            }
        })

    * */
}