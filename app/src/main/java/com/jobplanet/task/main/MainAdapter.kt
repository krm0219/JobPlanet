package com.jobplanet.task.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jobplanet.task.R
import com.jobplanet.task.databinding.ItemGithubBinding
import com.jobplanet.task.model.JobPlanetModel

class MainAdapter() : ListAdapter<JobPlanetModel, MainAdapter.ViewHolder>(RepoDiffUtil) {

    var repositories: List<JobPlanetModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemGithubBinding>(layoutInflater, viewType, parent, false)
        return ViewHolder(binding);
    }

    override fun getItemViewType(position: Int): Int {

        return R.layout.item_github
    }

    override fun getItemCount(): Int {

        return repositories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val repository = repositories[position]
        holder.bind(repository)
    }

    inner class ViewHolder(private val binding: ItemGithubBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(repository: JobPlanetModel) {

            binding.repository = repository
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

        this.repositories = repositories
        notifyDataSetChanged()
    }
}