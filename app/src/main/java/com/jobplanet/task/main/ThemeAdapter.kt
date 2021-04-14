package com.jobplanet.task.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jobplanet.task.R
import com.jobplanet.task.databinding.ItemThemeBinding
import com.jobplanet.task.model.ThemeModel

class ThemeAdapter : ListAdapter<ThemeModel, ThemeAdapter.ViewHolder>(
    ThemeDiffUtil
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemThemeBinding>(layoutInflater, viewType, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_theme
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val theme = getItem(position)
        holder.bind(theme)
    }


    inner class ViewHolder(private val binding: ItemThemeBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(theme: ThemeModel) {

            binding.theme = theme
            binding.executePendingBindings()
        }
    }


    companion object ThemeDiffUtil : DiffUtil.ItemCallback<ThemeModel>() {

        override fun areItemsTheSame(oldItem: ThemeModel, newItem: ThemeModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ThemeModel, newItem: ThemeModel): Boolean {
            return oldItem == newItem
        }
    }
}