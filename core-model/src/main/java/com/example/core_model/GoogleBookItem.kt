package com.example.core_model

data class GoogleBookItem(
    val title : String,
    val subTitle : String,
    val publisher : String,
    val publishedDate : String,
    val description : String,
    val imageLink : String,
    val authors : List<String>
)