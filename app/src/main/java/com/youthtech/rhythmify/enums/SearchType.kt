package com.youthtech.rhythmify.enums

enum class SearchType(private val value: String) {
    SONG("song"),
    PLAYLIST("playlist"),
    ARTIST("artist"),
    VIDEO("video");

    override fun toString(): String {
        return value
    }
}