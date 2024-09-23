package com.youthtech.rhythmify.ui.adapters.diff_utils

import androidx.recyclerview.widget.DiffUtil
import com.youthtech.rhythmify.data.network.dto.Banner

class BannerDiffUtil constructor(
    private val oldList: List<Banner>,
    private val newList: List<Banner>
) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return this.oldList.size
    }

    override fun getNewListSize(): Int {
        return this.newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].link == newList[newItemPosition].link
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].link == newList[newItemPosition].link
    }
}