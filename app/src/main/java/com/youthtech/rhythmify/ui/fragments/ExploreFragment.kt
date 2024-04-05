package com.youthtech.rhythmify.ui.fragments

import android.annotation.SuppressLint
import android.view.LayoutInflater
import com.google.android.material.chip.Chip
import com.youthtech.rhythmify.R
import com.youthtech.rhythmify.databinding.FragmentExploreBinding
import com.youthtech.rhythmify.ui.base.BaseFragment

class ExploreFragment : BaseFragment<FragmentExploreBinding>(FragmentExploreBinding::inflate) {
    val dummyGenre = ArrayList<String>();
    override fun init() {
        renderGenre()

    }

    override fun addListener() {
        binding.chipGrGenre.setOnCheckedStateChangeListener { _, ints ->
            println(dummyGenre[ints[0]])
        }
    }

    @SuppressLint("InflateParams")
    fun renderGenre() {
        dummyGenre.add("Kpop")
        dummyGenre.add("hiphop")
        dummyGenre.add("Rap")
        dummyGenre.add("Jazz")
        dummyGenre.add("Cháy")
        dummyGenre.add("OKela")
        dummyGenre.add("sdsds")
        dummyGenre.add("sdsdsdsdsd")
        dummyGenre.forEachIndexed { index, s ->
            val chip: Chip = LayoutInflater.from(context).inflate(R.layout.item_genre, null) as Chip
            chip.text = s;
            chip.id = index
            binding.chipGrGenre.addView(chip)
        }
    }
}