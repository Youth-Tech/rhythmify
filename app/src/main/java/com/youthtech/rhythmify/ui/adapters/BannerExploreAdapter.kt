package com.youthtech.rhythmify.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.youthtech.rhythmify.data.models.BannerItem
import com.youthtech.rhythmify.databinding.ItemCarouselBinding

class BannerExploreAdapter(
    private val context: Context,
    private var listBanner: ArrayList<BannerItem>,
    private val bannerExploreHandler: BannerExploreHandler
) : RecyclerView.Adapter<BannerExploreAdapter.BannerExploreViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setListBanner(listBanner: ArrayList<BannerItem>) {
        this.listBanner = listBanner
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerExploreViewHolder {
        val itemCarouselBinding =
            ItemCarouselBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerExploreViewHolder(itemCarouselBinding)
    }

    override fun onBindViewHolder(holder: BannerExploreViewHolder, position: Int) {
        holder.binding.apply {
            Glide.with(context).load(listBanner[position].banner)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(listItemImage)

            carouselItemContainer.setOnClickListener {
                    listBanner[position].let {
                        bannerExploreHandler.onItemClick(it)
                    }
            }
        }

    }

    override fun getItemCount(): Int = listBanner.size

    class BannerExploreViewHolder(val binding: ItemCarouselBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface BannerExploreHandler {
        fun onItemClick(item: BannerItem)
    }

}