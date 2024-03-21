import com.google.gson.annotations.SerializedName;
import com.youthtech.rhythmify.data.dto.Album
import com.youthtech.rhythmify.data.dto.Artist


data class ZingGetHomeChartResponse(
    val err: Long,
    val msg: String,
    val data: ZingGetHomeChartData,
    val timestamp: Long,
)

data class ZingGetHomeChartData(
    @SerializedName("RTChart")
    val rtchart: Rtchart,
    val newRelease: List<NewRelease>,
    val weekChart: WeekChart,
)

data class Rtchart(
    val promotes: List<Promote>,
    val items: List<Item>,
    val chart: Chart,
    val chartType: String,
    val sectionType: String,
    val sectionId: String,
)

data class Promote(
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
    val album: Album,
    val distributor: String,
    val indicators: List<String>,
    val isIndie: Boolean,
    val streamingStatus: Long,
    val allowAudioAds: Boolean,
    val hasLyric: Boolean,
    val previewInfo: PreviewInfo?,
    val downloadPrivileges: List<Long>?,
    val streamPrivileges: List<Long>?,
    val mvlink: String?,
)





data class PreviewInfo(
    val startTime: Long,
    val endTime: Long,
)

data class Item(
    val encodeId: String,
    val title: String,
    val alias: String,
    val isOffical: Boolean,
    val username: String,
    val artistsNames: String,
    val artists: List<Artist>,
    val isWorldWide: Boolean,
    val previewInfo: PreviewInfo2?,
    val thumbnailM: String,
    val link: String,
    val thumbnail: String,
    val duration: Long,
    val zingChoice: Boolean,
    val isPrivate: Boolean,
    val preRelease: Boolean,
    val releaseDate: Long,
    val genreIds: List<String>,
    val album: Album,
    val distributor: String,
    val indicators: List<Any?>,
    val isIndie: Boolean,
    val streamingStatus: Long,
    val allowAudioAds: Boolean,
    val hasLyric: Boolean?,
    val rakingStatus: Long,
    val score: Long,
    val totalTopZing: Long,
    val artist: Artist?,
    val downloadPrivileges: List<Long>?,
    val mvlink: String?,
)



data class PreviewInfo2(
    val startTime: Long,
    val endTime: Long,
)










data class Chart(
    val times: List<Time>,
    val minScore: Long,
    val maxScore: Double,
    val items: Map<String, List<Items>>,
    val totalScore: Long,
)

data class Time(
    val hour: String,
)

data class Items(
    val time: Long,
    val hour: String,
    val counter: Long,
)

data class NewRelease(
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
    val album: Album,
    val distributor: String,
    val indicators: List<Any?>,
    val isIndie: Boolean,
    val streamingStatus: Long,
    val allowAudioAds: Boolean,
    val hasLyric: Boolean,
    val previewInfo: PreviewInfo3?,
    val mvlink: String?,
    val downloadPrivileges: List<Long>?,
)



data class PreviewInfo3(
    val startTime: Long,
    val endTime: Long,
)

data class WeekChart(
    val vn: Vn,
    val us: Us,
    val korea: Korea,
)

data class Vn(
    val banner: String,
    val playlistId: String,
    val chartId: Long,
    val cover: String,
    val country: String,
    val type: String,
    val group: List<Group>,
    val link: String,
    val week: Long,
    val year: Long,
    val latestWeek: Long,
    val startDate: String,
    val endDate: String,
    val items: List<Item2>,
    val sectionId: String,
)

data class Group(
    val id: Long,
    val name: String,
    val type: String,
    val link: String,
)

data class Item2(
    val encodeId: String,
    val title: String,
    val alias: String,
    val isOffical: Boolean,
    val username: String,
    val artistsNames: String,
    val artists: List<Artist>,
    val isWorldWide: Boolean,
    val previewInfo: PreviewInfo4,
    val thumbnailM: String,
    val link: String,
    val thumbnail: String,
    val duration: Long,
    val zingChoice: Boolean,
    val isPrivate: Boolean,
    val preRelease: Boolean,
    val releaseDate: Long,
    val genreIds: List<String>,
    val album: Album,
    val distributor: String,
    val indicators: List<Any?>,
    val isIndie: Boolean,
    val streamingStatus: Long,
    val allowAudioAds: Boolean,
    val hasLyric: Boolean,
    val rakingStatus: Long,
    val score: Long,
    val downloadPrivileges: List<Long>?,
    val mvlink: String?,
)



data class PreviewInfo4(
    val startTime: Long,
    val endTime: Long,
)



data class Us(
    val banner: String,
    val playlistId: String,
    val chartId: Long,
    val cover: String,
    val country: String,
    val type: String,
    val group: List<Group2>,
    val link: String,
    val week: Long,
    val year: Long,
    val latestWeek: Long,
    val startDate: String,
    val endDate: String,
    val items: List<Item3>,
    val sectionId: String,
)

data class Group2(
    val id: Long,
    val name: String,
    val type: String,
    val link: String,
)

data class Item3(
    val encodeId: String,
    val title: String,
    val alias: String,
    val isOffical: Boolean,
    val username: String,
    val artistsNames: String,
    val artists: List<Artist>,
    val isWorldWide: Boolean,
    val previewInfo: PreviewInfo5?,
    val thumbnailM: String,
    val link: String,
    val thumbnail: String,
    val duration: Long,
    val zingChoice: Boolean,
    val isPrivate: Boolean,
    val preRelease: Boolean,
    val releaseDate: Long,
    val genreIds: List<String>,
    val album: Album,
    val distributor: String,
    val indicators: List<String>,
    val isIndie: Boolean,
    val streamingStatus: Long,
    val streamPrivileges: List<Long>,
    val downloadPrivileges: List<Long>,
    val allowAudioAds: Boolean,
    val hasLyric: Boolean?,
    val rakingStatus: Long,
    val score: Long,
    val radioId: Long?,
    val mvlink: String?,
)


data class PreviewInfo5(
    val startTime: Long,
    val endTime: Long,
)




data class Korea(
    val banner: String,
    val playlistId: String,
    val chartId: Long,
    val cover: String,
    val country: String,
    val type: String,
    val group: List<Group3>,
    val link: String,
    val week: Long,
    val year: Long,
    val latestWeek: Long,
    val startDate: String,
    val endDate: String,
    val items: List<Item4>,
    val sectionId: String,
)

data class Group3(
    val id: Long,
    val name: String,
    val type: String,
    val link: String,
)

data class Item4(
    val encodeId: String,
    val title: String,
    val alias: String,
    val isOffical: Boolean,
    val username: String,
    val artistsNames: String,
    val artists: List<Artist>,
    val isWorldWide: Boolean,
    val previewInfo: PreviewInfo6,
    val thumbnailM: String,
    val link: String,
    val thumbnail: String,
    val duration: Long,
    val zingChoice: Boolean,
    val isPrivate: Boolean,
    val preRelease: Boolean,
    val releaseDate: Long,
    val genreIds: List<String>,
    val album: Album,
    val distributor: String,
    val indicators: List<Any?>,
    val isIndie: Boolean,
    val streamingStatus: Long,
    val downloadPrivileges: List<Long>,
    val allowAudioAds: Boolean,
    val rakingStatus: Long,
    val score: Long,
    val hasLyric: Boolean?,
    val mvlink: String?,
    val streamPrivileges: List<Long>?,
)


data class PreviewInfo6(
    val startTime: Long,
    val endTime: Long,
)



