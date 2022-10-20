package com.example.core_model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GoogleBookItem(
    val title: String,
    val subTitle: String,
    val publisher: String,
    val publishedDate: String,
    val description: String,
    val imageLink: String,
    val authors: List<String>
) : Parcelable