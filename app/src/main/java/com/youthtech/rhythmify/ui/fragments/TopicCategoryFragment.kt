package com.youthtech.rhythmify.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.youthtech.rhythmify.data.network.dto.Topic
import com.youthtech.rhythmify.databinding.FragmentTopicCategoryBinding
import com.youthtech.rhythmify.ui.adapters.BannerAdapter
import com.youthtech.rhythmify.ui.adapters.BaseCategoryAdapter
import com.youthtech.rhythmify.ui.adapters.TopicCategoryAdapter
import com.youthtech.rhythmify.ui.adapters.decorators.SpaceItemDecoration
import com.youthtech.rhythmify.ui.base.BaseFragment
import com.youthtech.rhythmify.utils.Resource
import com.youthtech.rhythmify.viewmodels.TopicCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class TopicCategoryFragment :
    BaseFragment<FragmentTopicCategoryBinding>(FragmentTopicCategoryBinding::inflate) {

    private val topicCategoryViewModel: TopicCategoryViewModel by viewModels()
    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var featuredAdapter: BaseCategoryAdapter
    private lateinit var nationAdapter: BaseCategoryAdapter
    private lateinit var moodAndActivityAdapter: TopicCategoryAdapter

    override fun init() {
        //init banner carousel
        val carouselLayoutManager = CarouselLayoutManager(FullScreenCarouselStrategy())
        bannerAdapter = BannerAdapter(arrayListOf())

        binding.banner.layoutManager = carouselLayoutManager
        binding.banner.adapter = bannerAdapter

        //handle snap helper
        val snapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(binding.banner)

        //init outstanding list
        featuredAdapter = BaseCategoryAdapter(arrayListOf())
        binding.featuredList.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.featuredList.adapter = featuredAdapter
        binding.featuredList.addItemDecoration(SpaceItemDecoration(2, 15))

        //init nation list
        nationAdapter = BaseCategoryAdapter(arrayListOf())
        binding.nationList.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.nationList.adapter = nationAdapter
        binding.nationList.addItemDecoration(SpaceItemDecoration(2, 15))

        //init mood and activity list
        moodAndActivityAdapter = TopicCategoryAdapter(arrayListOf())
        binding.moodActivityList.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.moodActivityList.adapter = moodAndActivityAdapter
        binding.moodActivityList.addItemDecoration(SpaceItemDecoration(2, 15))
    }

    override fun addListener() {
        //add data banner
        lifecycleScope.launch(Dispatchers.IO) {
            topicCategoryViewModel.hubHome.collect { data ->
                withContext(Dispatchers.Main) {
                    when (data) {
                        is Resource.Error -> {
                            Log.e(TAG, "topicCategoryViewModel: ${data.err?.message}")
                        }

                        is Resource.Loading -> {
                            //handle loading state for banner
                        }

                        is Resource.Success -> {
                            //set data banner
                            bannerAdapter.setData(data.data?.data?.banners ?: arrayListOf())

                            //set data featured list
                            featuredAdapter.setData(
                                data.data?.data?.featured?.items ?: arrayListOf()
                            )
                            binding.featureLabel.text = data.data?.data?.featured?.title ?: ""

                            //set data national list
//                            nationAdapter.setData(
//                                data.data?.data?.nations ?: arrayListOf()
//                            )

                            //set data mood and activity list
                            moodAndActivityAdapter.setData(
                                data.data?.data?.topic ?: arrayListOf()
                            )

                            Topic::class.java.declaredFields.forEach { field ->
                                data.data?.data?.topic?.get(0)?.let {
                                    Log.d(TAG, "addListener: ${field.get(it)}")
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}