package com.youthtech.rhythmify.data.repositories

import android.util.Log
import androidx.room.withTransaction
import com.youthtech.rhythmify.data.database.RhythmifyDatabase
import com.youthtech.rhythmify.data.database.daos.AlbumArtistRefDAO
import com.youthtech.rhythmify.data.database.daos.AlbumDAO
import com.youthtech.rhythmify.data.database.daos.ArtistDAO
import com.youthtech.rhythmify.data.database.daos.ComposerDAO
import com.youthtech.rhythmify.data.database.daos.GenreDAO
import com.youthtech.rhythmify.data.database.daos.SongArtistRefDAO
import com.youthtech.rhythmify.data.database.daos.SongComposerRefDAO
import com.youthtech.rhythmify.data.database.daos.SongDAO
import com.youthtech.rhythmify.data.database.daos.SongGenreRefDAO
import com.youthtech.rhythmify.data.models.Album
import com.youthtech.rhythmify.data.models.Song
import com.youthtech.rhythmify.data.models.album.AlbumArtistCrossRef
import com.youthtech.rhythmify.data.models.songinfo.SongComposerCrossRef
import com.youthtech.rhythmify.data.models.songinfo.SongGenreCrossRef
import com.youthtech.rhythmify.data.models.songinfo.SongInfo
import com.youthtech.rhythmify.data.network.api_models.ZingService
import com.youthtech.rhythmify.data.network.dto.ZingSongInfoResponse
import com.youthtech.rhythmify.data.network.utils.ApiPath
import com.youthtech.rhythmify.data.network.utils.hashHasIdSignature
import com.youthtech.rhythmify.extensions.toAlbumModel
import com.youthtech.rhythmify.extensions.toArtistModel
import com.youthtech.rhythmify.extensions.toComposerModel
import com.youthtech.rhythmify.extensions.toGenreModel
import com.youthtech.rhythmify.extensions.toSongModel
import com.youthtech.rhythmify.utils.networkBoundResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class TestRepository @Inject constructor(
    private val localDB: RhythmifyDatabase,
    private val zingService: ZingService
) {
    private val songDAO: SongDAO by lazy {
        localDB.songDao()
    }
    private val albumDAO: AlbumDAO by lazy {
        localDB.albumDao()
    }
    private val artistDAO: ArtistDAO by lazy {
        localDB.artistDao()
    }
    private val genreDAO: GenreDAO by lazy {
        localDB.genreDao()
    }
    private val composerDAO: ComposerDAO by lazy {
        localDB.composerDao()
    }
    private val songArtistRefDAO: SongArtistRefDAO by lazy {
        localDB.songArtistCrossRefDao()
    }
    private val songComposerRefDAO: SongComposerRefDAO by lazy {
        localDB.songComposerCrossRefDao()
    }
    private val songGenreRefDAO: SongGenreRefDAO by lazy {
        localDB.songGenreCrossRefDao()
    }
    private val albumArtistRefDAO: AlbumArtistRefDAO by lazy {
        localDB.albumArtistCrossRefDao()
    }

    fun getSongInfo(musicId: String) = networkBoundResource(
        query = {
            Log.d("getSongInfo", "getSongInfo: query lambda")
            songDAO.getSongById(musicId)
        },
        fetch = {
            Log.d("getSongInfo", "getSongInfo: fetch lambda")
            delay(100)
            zingService.getSongInfo(musicId, hashHasIdSignature(ApiPath.GET_SONG_INFO, musicId))
        },
        saveFetchResult = { res ->
            Log.d("getSongInfo", "getSongInfo: saveFetchResult lambda")
            localDB.withTransaction {
                // add album
                res.body()?.let { body ->
                    val album: Album = body.data.album.toAlbumModel()
                    albumDAO.insert(album)

                    //add artists album
                    val artists = body.data.album.artists
                    artists?.forEach {
                        artistDAO.insert(it.toArtistModel())
                        val albumArtistCrossRef = AlbumArtistCrossRef(album.id, it.id)
                        albumArtistRefDAO.insert(albumArtistCrossRef)
                    }

                    //add genres
                    val genres = body.data.genres
                    genres?.forEach {
                        genreDAO.insert(it.toGenreModel())
                        val songGenreCrossRef = SongGenreCrossRef(body.data.encodeId, it.id)
                        songGenreRefDAO.insert(songGenreCrossRef)
                    }

                    //add composer
                    val composers = body.data.composers
                    composers?.forEach {
                        composerDAO.insert(it.toComposerModel())
                        val songComposerCrossRef =
                            SongComposerCrossRef(body.data.encodeId, it.id)
                        songComposerRefDAO.insert(songComposerCrossRef)
                    }

                    songDAO.insert(body.data.toSongModel())
                }
            }
        }
    )
}