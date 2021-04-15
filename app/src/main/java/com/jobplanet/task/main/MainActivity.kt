package com.jobplanet.task.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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


        viewModel.showErrorToast.observe(this, Observer {

            it.getContentIfNotHandled()?.let {

                Toast.makeText(this@MainActivity, R.string.msg_error, Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.item.observe(this, Observer {

            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("item", it)
            startActivity(intent)
        })


        setRecyclerView()
    }

    private fun setRecyclerView() {

        val adapter = MainAdapter(viewModel)

        binding.recyclerMainList.adapter = adapter
        binding.recyclerMainList.setHasFixedSize(true)

        viewModel.jobs.observe(this, Observer {

            adapter.setData(it)
        })
    }
}