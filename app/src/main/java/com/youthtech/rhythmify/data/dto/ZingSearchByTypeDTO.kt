package com.youthtech.rhythmify.data.dto

import com.google.gson.annotations.SerializedName

data class ZingSearchByTypeResponse(
    val err: Long,
    val msg: String,
    val data: ZingSearchByTypeData,
    val timestamp: Long,
)

data class ZingSearchByTypeData(
    val correctKeyword: Any?,
    val items: List<Any>,
    val total: Long,
    val sectionId: String,
)

/*
* map to "items" field at ZingSearchByTypeData data class
* */
sealed class ZingSearchByTypeDataItem {
    data class ZingSearchByTypeArtistItem(
        val id: String,
        val name: String,
        val link: String,
        val spotlight: Boolean,
        val alias: String,
        val thumbnail: String,
        val thumbnailM: String,
        val isOA: Boolean,
        val isOABrand: Boolean,
        val playlistId: String?,
        val totalFollow: Long,
    ) : ZingSearchByTypeDataItem()

    data class ZingSearchByTypeSongItem(
        val encodeId: String,
        val title: String,
        val alias: String,
        val isOffical: Boolean,
        val username: String,
        val artistsNames: String,
        val artists: List<Artist>,
        val isWorldWide: Boolean,
        val thumbnailM: String,
        val link: String,
        val thumbnail: String,
        val duration: Long,
        val zingChoice: Boolean,
        val isPrivate: Boolean,
        val preRelease: Boolean,
        val releaseDate: Long,
        val genreIds: List<String>,
        val distributor: String,
        val indicators: List<Any?>,
        val isIndie: Boolean,
        val streamingStatus: Long,
        val streamPrivileges: List<Long>?,
        val downloadPrivileges: List<Long>?,
        val allowAudioAds: Boolean,
        val publicStatus: Long,
        val statusCode: Long,
        val statusName: String,
        val uid: Long,
        val uname: String,
        val canEdit: Boolean,
        val canDelete: Boolean,
        val album: Album,
        val previewInfo: PreviewInfo?,
        val radioId: Long?,
        val hasLyric: Boolean?,
        val mvlink: String?,
    ) : ZingSearchByTypeDataItem()

    data class ZingSearchByTypePlaylistItem(
        val encodeId: String,
        val title: String,
        val thumbnail: String,
        val isoffical: Boolean,
        val link: String,
        val isIndie: Boolean,
        val releaseDate: String,
        val sortDescription: String,
        val releasedAt: Long,
        val genreIds: List<String>,
        @SerializedName("PR")
        val pr: Boolean,
        val artists: List<Artist>?,
        val artistsNames: String?,
        val playItemMode: Long,
        val subType: Long,
        val uid: Long,
        val thumbnailM: String,
        val isShuffle: Boolean,
        val isPrivate: Boolean,
        val userName: String,
        val isAlbum: Boolean,
        val textType: String,
        val isSingle: Boolean,
        val isOwner: Boolean,
        val canEdit: Boolean,
        val canDelete: Boolean,
    ) : ZingSearchByTypeDataItem()

    data class ZingSearchByTypeVideoItem(
        val encodeId: String,
        val title: String,
        val alias: String,
        val isOffical: Boolean,
        val username: String,
        val artistsNames: String,
        val artists: List<Artist>,
        val isWorldWide: Boolean,
        val thumbnailM: String,
        val link: String,
        val thumbnail: String,
        val duration: Long,
        val streamingStatus: Long,
        val streamPrivileges: List<Long>,
        val artist: Artist,
    ) : ZingSearchByTypeDataItem()

}
