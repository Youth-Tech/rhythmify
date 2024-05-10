package com.youthtech.rhythmify.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.youthtech.rhythmify.data.network.dto.Topic
import com.youthtech.rhythmify.databinding.ItemTopicCategoryBinding
import com.youthtech.rhythmify.extensions.glide
import com.youthtech.rhythmify.ui.adapters.diff_utils.TopicCategoryDiffUtil

class TopicCategoryAdapter(private val listTopic: ArrayList<Topic>) :
    RecyclerView.Adapter<TopicCategoryAdapter.TopicCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicCategoryViewHolder {
        val binding =
            ItemTopicCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopicCategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listTopic.size
    }

    override fun onBindViewHolder(holder: TopicCategoryViewHolder, position: Int) {
        holder.onBind(listTopic[position])
    }

    fun setData(listTopic: List<Topic>) {
        val diffResult = DiffUtil.calculateDiff(TopicCategoryDiffUtil(this.listTopic, listTopic))
        diffResult.dispatchUpdatesTo(this)
        this.listTopic.clear()
        this.listTopic.addAll(listTopic)
    }

    inner class TopicCategoryViewHolder(private val binding: ItemTopicCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(topic: Topic) {
            binding.topicName.text = topic.title
            binding.root.context.glide(topic.thumbnail, binding.thumbnail)
            if (topic.playlists.size > 2) {
                binding.root.context.glide(topic.playlists[0].thumbnail, binding.firstPlaylist)
                binding.root.context.glide(topic.playlists[1].thumbnail, binding.secondPlaylist)
            }
        }
    }

}