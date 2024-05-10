package com.youthtech.rhythmify.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.youthtech.rhythmify.data.network.dto.BaseCategoryItem
import com.youthtech.rhythmify.databinding.ItemBaseCategoryBinding
import com.youthtech.rhythmify.extensions.glide
import com.youthtech.rhythmify.ui.adapters.diff_utils.FeaturedDiffUtil

class BaseCategoryAdapter(private val listFeatured: ArrayList<BaseCategoryItem>) :
    RecyclerView.Adapter<BaseCategoryAdapter.BaseCategoryAdapterViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseCategoryAdapterViewHolder {
        val binding =
            ItemBaseCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BaseCategoryAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listFeatured.size
    }

    override fun onBindViewHolder(holder: BaseCategoryAdapterViewHolder, position: Int) {
        holder.onBind(listFeatured[position])
    }

    fun setData(listFeatured: List<BaseCategoryItem>) {
        val diffResult = DiffUtil.calculateDiff(FeaturedDiffUtil(this.listFeatured, listFeatured))
        diffResult.dispatchUpdatesTo(this)
        this.listFeatured.clear()
        this.listFeatured.addAll(listFeatured)
    }

    inner class BaseCategoryAdapterViewHolder(private val binding: ItemBaseCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: BaseCategoryItem) {
            binding.root.context.glide(item.thumbnailHasText, binding.image)
        }
    }
}