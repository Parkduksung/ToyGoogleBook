package com.example.core_model.response

import com.example.core_model.GoogleBookItem
import com.google.gson.annotations.SerializedName

data class VolumeInfo(
    var allowAnonLogging: Boolean = false,
    @SerializedName("authors")
    var authors: List<String>? = emptyList(),
    var canonicalVolumeLink: String = "",
    val contentVersion: String = "",
    @SerializedName("description")
    var description: String? = "",
    @SerializedName("imageLinks")
    val imageLinks: ImageLinks?,
    var infoLink: String = "",
    var maturityRating: String = "",
    val panelizationSummary: PanelizationSummary,
    var previewLink: String = "",
    @SerializedName("publishedDate")
    var publishedDate: String? = "",
    @SerializedName("publisher")
    var publisher: String? = "",
    val readingModes: ReadingModes,
    @SerializedName("subtitle")
    var subtitle: String? = "",
    @SerializedName("title")
    var title: String? = ""
)

fun VolumeInfo.asGoogleBookItem(): GoogleBookItem =
    GoogleBookItem(
        title = title.orEmpty(),
        subTitle = subtitle.orEmpty(),
        publisher = publisher.orEmpty(),
        publishedDate = publishedDate.orEmpty(),
        description = description.orEmpty(),
        imageLink = imageLinks?.thumbnail.orEmpty(),
        authors = authors.orEmpty()
    )