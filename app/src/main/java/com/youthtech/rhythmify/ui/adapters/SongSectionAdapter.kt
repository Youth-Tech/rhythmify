package com.youthtech.rhythmify.ui.adapters

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.content.Context
import com.bumptech.glide.Glide
import android.view.LayoutInflater
import com.youthtech.rhythmify.data.models.Song
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.youthtech.rhythmify.databinding.ItemSongBinding

class SongSectionAdapter(
    private val context: Context,
    private var listSong: ArrayList<Song>,
    private val songSectionHandlerListener: SongSectionHandlerListener
) : RecyclerView.Adapter<SongSectionAdapter.SongSectionViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setListSong(listSong: ArrayList<Song>) {
        this.listSong = listSong
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongSectionViewHolder {
        val itemSongBinding =
            ItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SongSectionViewHolder(itemSongBinding)
    }

    override fun onBindViewHolder(holder: SongSectionViewHolder, position: Int) {
        holder.binding.apply {
            tvSongTitle.text = listSong[position].title
            tvSongComposer.text = listSong[position].artistsNames
            Glide.with(context).load(listSong[position].thumbnailM)
                .diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true)
                .into(ivSongThumnail)
            itemSong.setOnClickListener {
                View.OnClickListener {
                    listSong[position].let {
                        songSectionHandlerListener.onItemClick(it)
                    }
                }
            }
        }

    }

    override fun getItemCount(): Int = listSong.size

    class SongSectionViewHolder(val binding: ItemSongBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface SongSectionHandlerListener {
        fun onItemClick(song: Song)
    }

}