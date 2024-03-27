data class ZingGetRadioResponse(
    val err: Long,
    val msg: String,
    val data: ZingGetRadioData,
    val timestamp: Long,
)

data class ZingGetRadioData(
    val items: List<ZingGetRadioDataItem>,
    val hasMore: Boolean,
    val total: Long,
)

data class ZingGetRadioDataItem(
    val sectionType: String,
    val viewType: String?,
    val title: String?,
    val link: String?,
    val sectionId: String?,
    val items: List<RadioDataItem>,
)

data class RadioDataItem(
    val id: Long?,
    val encodeId: String?,
    val title: String?,
    val thumbnail: String?,
    val thumbnailM: String?,
    val thumbnailV: String?,
    val thumbnailH: String?,
    val description: String?,
    val status: Long?,
    val type: String?,
    val link: String?,
    val streaming: String?,
    val host: RadioDataItemHost?,
    val activeUsers: Long?,
    val program: RadioDataItemProgram?,
    val item: RadioDataItem?,
    val programs: List<RadioDataItemProgram>?,
)

data class RadioDataItemHost(
    val name: String,
    val encodeId: String,
    val thumbnail: String,
    val link: String,
)

data class RadioDataItemProgram(
    val id: Long?,
    val encodeId: String,
    val title: String,
    val thumbnail: String,
    val thumbnailH: String,
    val description: String,
    val startTime: Long,
    val endTime: Long,
    val hasSongRequest: Boolean,
    val genreIds: List<String>?,
)

