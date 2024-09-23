package com.youthtech.rhythmify.ui.adapters.diff_utils

import androidx.recyclerview.widget.DiffUtil
import com.youthtech.rhythmify.data.network.dto.Topic

class TopicCategoryDiffUtil(private val oldList: List<Topic>, private val newList: List<Topic>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].encodeId == newList[newItemPosition].encodeId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val isSameThumbnail =
            oldList[oldItemPosition].thumbnail == newList[newItemPosition].thumbnail
        val isSameTitle = oldList[oldItemPosition].title == newList[newItemPosition].title
        
        return isSameTitle && isSameThumbnail
    }
}