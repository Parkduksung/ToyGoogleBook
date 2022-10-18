package com.example.core_model.response

data class GoogleBookResponse(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)