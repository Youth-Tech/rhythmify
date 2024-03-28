package com.youthtech.rhythmify.extensions

import com.youthtech.rhythmify.data.models.Album
import com.youthtech.rhythmify.data.models.Artist
import com.youthtech.rhythmify.data.models.Composer
import com.youthtech.rhythmify.data.models.Genre
import com.youthtech.rhythmify.data.models.Song
import com.youthtech.rhythmify.data.network.dto.AlbumDTO
import com.youthtech.rhythmify.data.network.dto.ArtistDTO
import com.youthtech.rhythmify.data.network.dto.ComposerDTO
import com.youthtech.rhythmify.data.network.dto.GenreDTO
import com.youthtech.rhythmify.data.network.dto.SongDTO
import com.youthtech.rhythmify.data.network.dto.ZingSongInfoData

fun AlbumDTO.toAlbumModel(): Album = Album(
    id = encodeId,
    title = title,
    thumbnail = thumbnail,
    link = link,
    releaseDate = releaseDate,
    sortDescription = sortDescription,
    releasedAt = releasedAt,
    artistsNames = artistsNames
)

fun ArtistDTO.toArtistModel(): Artist = Artist(
    id = id,
    name = name,
    alias = alias,
    thumbnailM = thumbnailM,
    thumbnail = thumbnail,
    playlistId = playlistId,
    totalFollow = totalFollow
)

fun GenreDTO.toGenreModel(): Genre = Genre(
    id = id,
    name = name,
    title = title,
    alias = alias
)

fun ComposerDTO.toComposerModel(): Composer = Composer(
    id = id,
    name = name,
    alias = alias,
    cover = cover,
    thumbnail = thumbnail,
//    playlistId = playlistId,
    totalFollow = totalFollow
)

fun ZingSongInfoData.toSongModel(): Song = Song(
    encodeId = encodeId,
    title = title,
    alias = alias,
    artistsNames = artistsNames,
    thumbnailM = thumbnailM,
    link = link,
    thumbnail = thumbnail,
    duration = duration,
    releaseDate = releaseDate,
    distributor = distributor,
    streamingStatus = streamingStatus,
    hasLyric = hasLyric,
    like = like,
    listen = listen,
    liked = liked,
    comment = comment,
    albumId = album.encodeId
)