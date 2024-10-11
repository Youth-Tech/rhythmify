package com.youthtech.rhythmify.enums

enum class HomeSectionType(private val value: String) {
    BANNER("banner"),
    RECENT("recentPlaylist"),
    NEW_RELEASE("new-release"),
    PLAYLIST("playlist"),
    NEW_RELEASE_CHART("newReleaseChart"),
    RT_CHART("RTChart"),
    AD_BANNER("adBanner"),
    LIVESTREAM("livestream");
    override fun toString(): String {
        return value
    }
}