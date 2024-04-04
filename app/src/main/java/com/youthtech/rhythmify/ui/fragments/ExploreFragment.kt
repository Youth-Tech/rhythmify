package com.youthtech.rhythmify.ui.fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import androidx.core.view.marginLeft
import androidx.core.view.updateLayoutParams
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
        binding.chipGrGenre.setOnCheckedStateChangeListener { chipGroup, ints ->
            println(dummyGenre[ints[0]])
        }
    }
    fun renderGenre(){
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
//            if(index == 0){
//                Log.d(TAG, "index $index")
//                val layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//                layoutParams.setMargins(20,0,0,0);
//                chip.layoutParams = layoutParams
//            }
//            if(index == dummyGenre.size - 1){
//                Log.d(TAG, "index $index")
//                val layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//                layoutParams.setMargins(0,0,20,0);
//                chip.layoutParams = layoutParams
//            }
            chip.text = s;
            chip.id = index
            binding.chipGrGenre.addView(chip)
        }
    }
}