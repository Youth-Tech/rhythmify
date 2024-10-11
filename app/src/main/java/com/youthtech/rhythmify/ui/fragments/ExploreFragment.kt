package com.youthtech.rhythmify.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.youthtech.rhythmify.data.models.BannerItem
import com.youthtech.rhythmify.data.models.Song
import com.youthtech.rhythmify.data.network.dto.ZingHomeDataItem
import com.youthtech.rhythmify.data.network.dto.ZingHomeItem
import com.youthtech.rhythmify.databinding.FragmentExploreBinding
import com.youthtech.rhythmify.ui.adapters.BannerExploreAdapter
import com.youthtech.rhythmify.ui.adapters.NewReleaseSongAdapter
import com.youthtech.rhythmify.ui.adapters.SongSectionAdapter
import com.youthtech.rhythmify.ui.base.BaseFragment
import com.youthtech.rhythmify.ui.components.ListSection
import com.youthtech.rhythmify.utils.Resource
import com.youthtech.rhythmify.viewmodels.HomeViewModel
import com.youthtech.rhythmify.viewmodels.TestViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Date

@AndroidEntryPoint

class ExploreFragment : BaseFragment<FragmentExploreBinding>(FragmentExploreBinding::inflate) {
    private var songSectionAdapter: SongSectionAdapter? = null
    private var exploreBannerAdapter: BannerExploreAdapter? = null
    private var newReleaseSongAdapter: NewReleaseSongAdapter? = null
    private val testViewModel: TestViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()
//    private lateinit var homeAdapter: HomeAdapter

    override fun init() {
        renderSongSection()
        renderBanner()
        renderNewReleaseSong()
//        homeAdapter = HomeAdapter(arrayListOf())
//        binding.rvHomeList.adapter = homeAdapter
    }

    override fun addListener() {
        // get home section
        lifecycleScope.launch(Dispatchers.IO) {
            homeViewModel.home.collect { data ->
                withContext(Dispatchers.Main) {
                    when (data) {
                        is Resource.Error -> {
                            Log.e(TAG, "homeViewModel: ${data.err?.message}")
                        }

                        is Resource.Loading -> {
                            //handle loading state
                        }

                        is Resource.Success -> {
                            Log.d(TAG, data.data?.data?.items.toString())
                            data.data?.data?.items?.forEachIndexed { index: Int, zingHomeDataItem: ZingHomeDataItem ->
                                when (zingHomeDataItem.sectionType) {
                                    "banner" -> {
                                        // Handle banner items
                                        zingHomeDataItem.items.forEach { zingItem ->
                                            when (zingItem) {
                                                is ZingHomeItem.BannerItem -> {
                                                    Log.d(TAG, "Banner Item: ${zingItem.banner}, Link: ${zingItem.link}")
                                                }
                                                // You can add more item types here if needed
                                                is ZingHomeItem.NewReleaseItem -> TODO()
                                                is ZingHomeItem.RecentPlaylistItem -> TODO()
                                            }
                                        }
                                    }
                                    "recentPlaylist" -> {
                                        // Handle recent playlist section
                                        Log.d(TAG, "Recent Playlist: ${zingHomeDataItem.title}")
                                    }
                                    "new-release" -> {
//                                        // Handle new release items (all property)
//                                        when (val zingItem = zingHomeDataItem.items) {
//                                            is ZingHomeItem.NewReleaseItem -> {
//                                                zingItem.all.forEach { newRelease ->
//                                                    Log.d(TAG, "New Release: $newRelease")
//                                                }
//                                            }
//                                            // You can add more item types here if needed
//                                        }
                                    }
                                    else -> {
                                        // Handle other sections if needed
                                        Log.d(TAG, "Other Section: ${zingHomeDataItem.sectionType}")
                                    }
                                }
                            }

//                            homeAdapter.setData(data.data?.data?.items ?: arrayListOf())
                        }
                    }
                }
            }
        }
    }


    fun renderSongSection() {
        val listSong = ArrayList<Song>();
        listSong.add(
            Song(
                link = "",
                comment = 2,
                like = 2000,
                albumId = "1",
                encodeId = "1",
                alias = "hey",
                listen = 2000,
                liked = false,
                thumbnail = "",
                duration = 2000,
                thumbnailM = "https://i1.sndcdn.com/artworks-0aDqhBAzd6pkEtIU-eJ1E1Q-t500x500.jpg",
                distributor = "",
                hasLyric = false,
                streamingStatus = 200,
                releaseDate = Date().time,
                artistsNames = "Obito, Shiki",
                title = "Tell the kids i love them"
            )
        )
        listSong.add(
            Song(
                link = "",
                comment = 2,
                like = 2000,
                albumId = "1",
                encodeId = "2",
                alias = "hey",
                listen = 2000,
                liked = false,
                thumbnail = "",
                duration = 2000,
                thumbnailM = "https://i1.sndcdn.com/artworks-zNPCYZm8KYjtySWa-00sV4Q-t500x500.jpg",
                distributor = "",
                hasLyric = false,
                streamingStatus = 200,
                releaseDate = Date().time,
                artistsNames = "Obito, MCK, Shiki",
                title = "Đánh đổi"
            )
        )
        listSong.add(
            Song(
                link = "",
                comment = 2,
                like = 2000,
                albumId = "1",
                encodeId = "3",
                alias = "hey",
                listen = 2000,
                liked = false,
                thumbnail = "",
                duration = 2000,
                thumbnailM = "https://avatar-ex-swe.nixcdn.com/song/2023/10/02/c/5/c/8/1696252949117_640.jpg",
                distributor = "",
                hasLyric = false,
                streamingStatus = 200,
                releaseDate = Date().time,
                artistsNames = "Richie D. Icy, Obito",
                title = "No Boundary"
            )
        )
        listSong.add(
            Song(
                link = "",
                comment = 2,
                like = 2000,
                albumId = "1",
                encodeId = "4",
                alias = "hey",
                listen = 2000,
                liked = false,
                thumbnail = "https://i1.sndcdn.com/artworks-0aDqhBAzd6pkEtIU-eJ1E1Q-t500x500.jpg",
                duration = 2000,
                thumbnailM = "",
                distributor = "",
                hasLyric = false,
                streamingStatus = 200,
                releaseDate = Date().time,
                artistsNames = "Obito, Shiki",
                title = "Sài Gòn ơi"
            )
        )
        listSong.add(
            Song(
                link = "",
                comment = 2,
                like = 2000,
                albumId = "1",
                encodeId = "5",
                alias = "hey",
                listen = 2000,
                liked = false,
                thumbnail = "",
                duration = 2000,
                thumbnailM = "https://avatar-ex-swe.nixcdn.com/song/2024/01/19/a/7/c/7/1705672852760_640.jpg",
                distributor = "",
                hasLyric = false,
                streamingStatus = 200,
                releaseDate = Date().time,
                artistsNames = "Low G, Obito, WOKEUP",
                title = "Phong Long"
            )
        )
        songSectionAdapter = SongSectionAdapter(
            requireContext(),
            listSong,
            object : SongSectionAdapter.SongSectionHandlerListener {
                override fun onItemClick(song: Song) {
                    Log.d(TAG, song.title);
                }
            })
        binding.lsSong.setSectionName("Hip-hop")
        binding.lsSong.setOnWatchMoreListener(object : ListSection.WatchMoreButtonHandler {
            override fun onMoreButtonClick() {
                Log.d(TAG, " oke")
            }
        })
        binding.lsSong.setAdapter(songSectionAdapter!!)

    }

    fun renderBanner() {
        val listBanner = ArrayList<BannerItem>();
        listBanner.add(
            BannerItem(
                encodeId = "1",
                title = "",
                description = "",
                link = "",
                ispr = 0,
                type = 0,
                target = "1",
                cover = "",
                banner = "https://photo-zmp3.zmdcdn.me/banner/4/5/7/b/457b0f448c986b14d33aeccef576ebaa.jpg"
            )
        )
        listBanner.add(
            BannerItem(
                encodeId = "2",
                title = "",
                description = "",
                link = "",
                ispr = 0,
                type = 0,
                target = "1",
                cover = "",
                banner = "https://photo-zmp3.zmdcdn.me/banner/4/5/7/b/457b0f448c986b14d33aeccef576ebaa.jpg"
            )
        )
        listBanner.add(
            BannerItem(
                encodeId = "3",
                title = "",
                description = "",
                link = "",
                ispr = 0,
                type = 0,
                target = "1",
                cover = "",
                banner = "https://photo-zmp3.zmdcdn.me/banner/4/5/7/b/457b0f448c986b14d33aeccef576ebaa.jpg"
            )
        )
        listBanner.add(
            BannerItem(
                encodeId = "4",
                title = "",
                description = "",
                link = "",
                ispr = 0,
                type = 0,
                target = "1",
                cover = "",
                banner = "https://photo-zmp3.zmdcdn.me/banner/4/5/7/b/457b0f448c986b14d33aeccef576ebaa.jpg"
            )
        )
//        exploreBannerAdapter = BannerExploreAdapter(
//            requireContext(),
//            listBanner,
//            object : BannerExploreAdapter.BannerExploreHandler {
//                override fun onItemClick(item: BannerItem) {
//                    Log.d(TAG, item.banner);
//                }
//
//            })
//        binding.rvBanner.adapter = exploreBannerAdapter;

    }

    fun renderNewReleaseSong() {
        val listSong = ArrayList<Song>();
        listSong.add(
            Song(
                link = "",
                comment = 2,
                like = 2000,
                albumId = "1",
                encodeId = "1",
                alias = "hey",
                listen = 2000,
                liked = false,
                thumbnail = "",
                duration = 2000,
                thumbnailM = "https://i1.sndcdn.com/artworks-0aDqhBAzd6pkEtIU-eJ1E1Q-t500x500.jpg",
                distributor = "",
                hasLyric = false,
                streamingStatus = 200,
                releaseDate = Date().time,
                artistsNames = "Obito, Shiki",
                title = "Tell the kids i love them"
            )
        )
        listSong.add(
            Song(
                link = "",
                comment = 2,
                like = 2000,
                albumId = "1",
                encodeId = "2",
                alias = "hey",
                listen = 2000,
                liked = false,
                thumbnail = "",
                duration = 2000,
                thumbnailM = "https://i1.sndcdn.com/artworks-zNPCYZm8KYjtySWa-00sV4Q-t500x500.jpg",
                distributor = "",
                hasLyric = false,
                streamingStatus = 200,
                releaseDate = Date().time,
                artistsNames = "Obito, MCK, Shiki",
                title = "Đánh đổi"
            )
        )
        listSong.add(
            Song(
                link = "",
                comment = 2,
                like = 2000,
                albumId = "1",
                encodeId = "3",
                alias = "hey",
                listen = 2000,
                liked = false,
                thumbnail = "",
                duration = 2000,
                thumbnailM = "https://avatar-ex-swe.nixcdn.com/song/2023/10/02/c/5/c/8/1696252949117_640.jpg",
                distributor = "",
                hasLyric = false,
                streamingStatus = 200,
                releaseDate = Date().time,
                artistsNames = "Richie D. Icy, Obito",
                title = "No Boundary"
            )
        )
        listSong.add(
            Song(
                link = "",
                comment = 2,
                like = 2000,
                albumId = "1",
                encodeId = "4",
                alias = "hey",
                listen = 2000,
                liked = false,
                thumbnail = "",
                duration = 2000,
                thumbnailM = "https://i1.sndcdn.com/artworks-0aDqhBAzd6pkEtIU-eJ1E1Q-t500x500.jpg",
                distributor = "",
                hasLyric = false,
                streamingStatus = 200,
                releaseDate = Date().time,
                artistsNames = "Obito, Shiki",
                title = "Sài Gòn ơi"
            )
        )
        listSong.add(
            Song(
                link = "",
                comment = 2,
                like = 2000,
                albumId = "1",
                encodeId = "5",
                alias = "hey",
                listen = 2000,
                liked = false,
                thumbnail = "",
                duration = 2000,
                thumbnailM = "https://avatar-ex-swe.nixcdn.com/song/2024/01/19/a/7/c/7/1705672852760_640.jpg",
                distributor = "",
                hasLyric = false,
                streamingStatus = 200,
                releaseDate = Date().time,
                artistsNames = "Low G, Obito, WOKEUP",
                title = "Phong Long"
            )
        )
        newReleaseSongAdapter = NewReleaseSongAdapter(
            requireContext(),
            listSong,
            object : NewReleaseSongAdapter.NewReleaseHandler {
                override fun onItemClick(song: Song) {
                    Log.d(TAG, song.title);
                }
            })

        binding.rvNewRelease.layoutManager =
            GridLayoutManager(requireContext(), 3, RecyclerView.HORIZONTAL, false)
        binding.rvNewRelease.adapter = newReleaseSongAdapter
    }
}