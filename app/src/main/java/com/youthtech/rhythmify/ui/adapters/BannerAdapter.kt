package com.youthtech.rhythmify.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.youthtech.rhythmify.data.network.dto.Banner
import com.youthtech.rhythmify.databinding.ItemBannerBinding
import com.youthtech.rhythmify.extensions.glide
import com.youthtech.rhythmify.ui.adapters.diff_utils.BannerDiffUtil

class BannerAdapter constructor(private var listBanner: ArrayList<Banner>) :
    RecyclerView.Adapter<BannerAdapter.BannerAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerAdapterViewHolder {
        val binding: ItemBannerBinding =
            ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return this.listBanner.size
    }

    fun setData(listBanner: List<Banner>) {
        val diffResult = DiffUtil.calculateDiff(BannerDiffUtil(this.listBanner, listBanner))
        diffResult.dispatchUpdatesTo(this)
        this.listBanner.clear()
        this.listBanner.addAll(listBanner)
    }

    override fun onBindViewHolder(holder: BannerAdapterViewHolder, position: Int) {
        holder.onBind(listBanner[position])
    }

    class BannerAdapterViewHolder(private val binding: ItemBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(banner: Banner) {
            binding.root.context.glide(banner.cover, binding.image)
        }
    }
}