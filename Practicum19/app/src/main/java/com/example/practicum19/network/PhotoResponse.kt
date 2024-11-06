package com.example.practicum19.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoResponse (
    @Json(name = "photo") val galleryItems: List<GalleryItem>
)