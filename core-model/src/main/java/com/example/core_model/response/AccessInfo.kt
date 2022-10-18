package com.example.core_model.response

data class AccessInfo(
    val accessViewStatus: String,
    val country: String,
    val epub: Epub,
    val pdf: Pdf
)