package com.youthtech.rhythmify.ui.adapters.diff_utils

import androidx.recyclerview.widget.DiffUtil
import com.youthtech.rhythmify.data.network.dto.BaseCategoryItem

class FeaturedDiffUtil(
    private val oldFeaturedList: List<BaseCategoryItem>,
    private val newFeaturedList: List<BaseCategoryItem>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldFeaturedList.size
    }

    override fun getNewListSize(): Int {
        return newFeaturedList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldFeaturedList[oldItemPosition].encodeId == newFeaturedList[newItemPosition].encodeId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val sameThumbnail =
            oldFeaturedList[oldItemPosition].thumbnailHasText == newFeaturedList[newItemPosition].thumbnailHasText
        val saneLink =
            oldFeaturedList[oldItemPosition].link == newFeaturedList[newItemPosition].link
        return sameThumbnail && saneLink
    }
}