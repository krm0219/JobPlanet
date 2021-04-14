package com.jobplanet.task.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jobplanet.task.R
import com.jobplanet.task.databinding.ItemCompanyBinding
import com.jobplanet.task.databinding.ItemHorizontalBinding
import com.jobplanet.task.databinding.ItemReviewBinding
import com.jobplanet.task.model.JobPlanetModel

class MainAdapter : ListAdapter<JobPlanetModel, MainAdapter.BaseViewHolder<*>>(RepoDiffUtil) {

    val TYPE_COMPANY = 0
    val TYPE_THEME = 1
    val TYPE_REVIEW = 2

    var jobs: List<JobPlanetModel> = listOf()


    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        Log.e("krm0219", "onCreateViewHolder  $viewType")
        when (viewType) {

            TYPE_COMPANY -> {

                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemCompanyBinding>(layoutInflater, R.layout.item_company, parent, false)
                return CompanyViewHolder(binding)
            }

            TYPE_THEME -> {

                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemHorizontalBinding>(layoutInflater, R.layout.item_horizontal, parent, false)
                return ThemeViewHolder(binding)
            }

            TYPE_REVIEW -> {

                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemReviewBinding>(layoutInflater, R.layout.item_review, parent, false)
                return ReviewViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {

        val data = jobs[position]

        when (holder) {

            is CompanyViewHolder -> holder.bind(data)
            is ThemeViewHolder -> holder.bind(data)
            is ReviewViewHolder -> holder.bind(data)
            else -> throw java.lang.IllegalArgumentException()
        }
    }


    override fun getItemViewType(position: Int): Int {

        return when (jobs[position].cellType) {
            "CELL_TYPE_COMPANY" -> TYPE_COMPANY
            "CELL_TYPE_HORIZONTAL_THEME" -> TYPE_THEME
            "CELL_TYPE_REVIEW" -> TYPE_REVIEW
            else -> TYPE_COMPANY
        }
    }

    override fun getItemCount(): Int {

        return jobs.size
    }

    inner class CompanyViewHolder(private val binding: ItemCompanyBinding) : BaseViewHolder<JobPlanetModel>(binding.root) {
        override fun bind(item: JobPlanetModel) {

            binding.company = item
            binding.executePendingBindings()
        }
    }

    inner class ThemeViewHolder(private val binding: ItemHorizontalBinding) : BaseViewHolder<JobPlanetModel>(binding.root) {
        override fun bind(item: JobPlanetModel) {

            binding.horizontal = item
            binding.executePendingBindings()
        }
    }

    inner class ReviewViewHolder(private val binding: ItemReviewBinding) : BaseViewHolder<JobPlanetModel>(binding.root) {
        override fun bind(item: JobPlanetModel) {

            binding.review = item
            binding.executePendingBindings()
        }
    }

    companion object RepoDiffUtil : DiffUtil.ItemCallback<JobPlanetModel>() {
        override fun areItemsTheSame(oldItem: JobPlanetModel, newItem: JobPlanetModel): Boolean {

            // 각 아이템들의 고유한 값을 비
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: JobPlanetModel, newItem: JobPlanetModel): Boolean {

            return oldItem == newItem
        }
    }

    fun setData(repositories: List<JobPlanetModel>) {

        this.jobs = repositories
        notifyDataSetChanged()
    }
}