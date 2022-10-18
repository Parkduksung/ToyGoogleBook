package com.example.core_model.response

data class SaleInfo(
    val buyLink: String,
    val country: String,
    val listPrice: ListPrice,
    val offers: List<Offer>,
    val retailPrice: RetailPriceX
)