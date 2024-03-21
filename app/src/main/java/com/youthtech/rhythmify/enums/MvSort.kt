package com.youthtech.rhythmify.enums

enum class MvSort(private val value: String) {
    LISTEN("listen"),
    HOT("hot"),
    NEW("new");

    override fun toString(): String {
        return value
    }
}