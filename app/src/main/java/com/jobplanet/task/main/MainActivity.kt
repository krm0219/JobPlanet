package com.jobplanet.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.jobplanet.task.databinding.ActivityMainBinding
import com.jobplanet.task.main.MainViewModel
import com.jobplanet.task.main.MainAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        setRecyclerView()
    }

    private fun setRecyclerView() {

        val adapter = MainAdapter()

        binding.recyclerMainList.adapter = adapter
        binding.recyclerMainList.setHasFixedSize(true)

//        viewModel.githubRepositories.observe(this, Observer {
//
//            adapter.setData(it)
//        })
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