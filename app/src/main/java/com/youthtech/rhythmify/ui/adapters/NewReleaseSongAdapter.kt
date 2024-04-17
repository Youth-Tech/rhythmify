package com.youthtech.rhythmify.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.youthtech.rhythmify.data.models.Song
import com.youthtech.rhythmify.databinding.ItemHorizontalSongBinding

class NewReleaseSongAdapter(
    private val context: Context,
    private var listSong: ArrayList<Song>,
    private val newReleaseHandler: NewReleaseHandler
) : RecyclerView.Adapter<NewReleaseSongAdapter.NewReleaseViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setListSong(listSong: ArrayList<Song>) {
        this.listSong = listSong
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewReleaseViewHolder {
        val itemHorizontalSongBinding =
            ItemHorizontalSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewReleaseViewHolder(itemHorizontalSongBinding)
    }

    override fun onBindViewHolder(holder: NewReleaseViewHolder, position: Int) {
        holder.binding.apply {

            tvTitle.text = listSong[position].title
            tvArtistNames.text = listSong[position].artistsNames
            Glide.with(context).load(listSong[position].thumbnailM)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivSongThumnail)
            itemHorizontalSong.setOnClickListener {
                listSong[position].let {
                    newReleaseHandler.onItemClick(it)
                }
            }
        }

    }

    override fun getItemCount(): Int = listSong.size

    class NewReleaseViewHolder(val binding: ItemHorizontalSongBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface NewReleaseHandler {
        fun onItemClick(song: Song)
    }

}