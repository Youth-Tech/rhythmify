package com.youthtech.rhythmify.ui.components

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.youthtech.rhythmify.R
import com.youthtech.rhythmify.data.models.Song

class ListSection : LinearLayout, View.OnClickListener {
    private lateinit var textViewSectionName: TextView
    private lateinit var icWatchMore: Button
    private lateinit var recyclerView: RecyclerView
    private var watchMoreHandler: WatchMoreButtonHandler? = null
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        LayoutInflater.from(context).inflate(R.layout.component_list_section, this);
        val style = getContext().theme.obtainStyledAttributes(attrs, R.styleable.ListSection, 0, 0);
        init(style)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr){
        LayoutInflater.from(context).inflate(R.layout.component_list_section, this);
        val style = getContext().theme.obtainStyledAttributes(attrs, R.styleable.ListSection, defStyleAttr, 0);
        init(style)
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int): super(context, attrs, defStyleAttr, defStyleRes){
        LayoutInflater.from(context).inflate(R.layout.component_list_section, this);
        val style = getContext().theme.obtainStyledAttributes(attrs, R.styleable.ListSection, defStyleAttr, defStyleRes);
        init(style)
    }
    fun init(style: TypedArray?) {
        textViewSectionName = findViewById(R.id.tv_sectionName)
        icWatchMore = findViewById(R.id.btn_watchmore)
        recyclerView = findViewById(R.id.rv_songList)
        icWatchMore.setOnClickListener(this@ListSection)
        if (style == null) return
        try {
            val sectionName = style.getString(R.styleable.ListSection_sectionName)
            val moreButton = style.getBoolean(R.styleable.ListSection_moreButton, true);
            textViewSectionName.text = sectionName;
            icWatchMore.visibility = if (moreButton) VISIBLE else GONE
        } catch (e: Exception) {
            Log.d(TAG, "listsection init: ${e.message}")
        } finally {
            style.recycle()
        }

    }
    fun setOnWatchMoreListener(watchMoreHandler: WatchMoreButtonHandler) {
        this.watchMoreHandler = watchMoreHandler
        requestLayout()
    }
    fun setSectionName(name: String){
        textViewSectionName.text = name
        requestLayout()
    }
    fun setAdapter(adapter: RecyclerView.Adapter<*>){
        recyclerView.adapter = adapter
        requestLayout()
    }
    override fun onClick(v: View) {
        if(v.id == R.id.btn_watchmore && watchMoreHandler != null){
            watchMoreHandler!!.onMoreButtonClick()
        }
    }
    companion object {
        private val TAG = ListSection::class.java.simpleName
    }
    interface WatchMoreButtonHandler {
        fun onMoreButtonClick()
    }
}

