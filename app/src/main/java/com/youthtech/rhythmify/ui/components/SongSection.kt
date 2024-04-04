package com.youthtech.rhythmify.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.youthtech.rhythmify.R

class SongSection @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    init {
        LayoutInflater.from(context).inflate(R.layout.component_song_section, this, true)
        orientation = VERTICAL
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.SongSectionComponent)
        val sectionName = typedArray.getString(R.styleable.SongSectionComponent_sectionName)
        typedArray.recycle()

        // Set attributes to views
        val textViewSectionName = findViewById<TextView>(R.id.tv_sectionName)

        textViewSectionName.text = sectionName
    }

    fun setAdapter(adapter: RecyclerView.Adapter<*>) {
        //TODO: Implement adapter

    }
}