package com.example.core_model.response

import com.google.gson.annotations.SerializedName

data class GoogleBookResponse(
    @SerializedName("items")
    var items: List<Item>? = emptyList(),
    val kind: String,
    val totalItems: Int
)