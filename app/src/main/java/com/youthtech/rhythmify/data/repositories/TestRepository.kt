package com.youthtech.rhythmify.data.repositories

import androidx.room.util.query
import androidx.room.withTransaction
import com.youthtech.rhythmify.data.database.RhythmifyDatabase
import com.youthtech.rhythmify.data.database.daos.SongDAO
import com.youthtech.rhythmify.data.network.api_models.ZingService
import com.youthtech.rhythmify.data.network.utils.ApiPath
import com.youthtech.rhythmify.data.network.utils.hashHasIdSignature
import com.youthtech.rhythmify.utils.networkBoundResource
import javax.inject.Inject

class TestRepository @Inject constructor(private val localDB: RhythmifyDatabase, private val zingService: ZingService) {
    private val songDAO : SongDAO by lazy {
        localDB.songDao()
    }
  fun getSongInfo(musicId: String) = networkBoundResource(
      query = {
          songDAO.getSongById(musicId)
      },
      fetch = {
          zingService.getSongInfo(musicId, hashHasIdSignature(ApiPath.GET_SONG_INFO, musicId);
      },
       saveFetchResult = {
           res -> localDB.withTransaction {

       }
       }
  )
}