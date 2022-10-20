package com.example.core_model

import com.example.core_model.response.*


val MOCK_GOOGLE_BOOK_RESPONSE =
    GoogleBookResponse(
        emptyList(),
        "",
        0
    )

val MOCK_GOOGLE_BOOK_ITEM =
    Item(
        accessInfo = AccessInfo("", "", Epub("", false), Pdf("", false)),
        etag = "",
        id = "",
        kind = "",
        saleInfo = SaleInfo("", "", ListPrice(0, ""), emptyList(), RetailPriceX(0, "")),
        searchInfo = SearchInfo(""),
        selfLink = "",
        volumeInfo = VolumeInfo(
            allowAnonLogging = false, emptyList(), "", "", "",
            ImageLinks("", ""), "", "",
            PanelizationSummary(containsEpubBubbles = false, containsImageBubbles = false),
            "", "", "", ReadingModes(false, text = false),
            "", ""
        )
    )