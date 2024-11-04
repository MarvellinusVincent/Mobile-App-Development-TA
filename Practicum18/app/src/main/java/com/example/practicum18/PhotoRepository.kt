package com.example.practicum18

import com.example.practicum18.network.Flicker
import com.example.practicum18.network.GalleryItem
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

class PhotoRepository {
    private val flicker: Flicker

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://api.flickr.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        flicker = retrofit.create<Flicker>()
    }

    suspend fun fetchContent() =
        flicker.fetchContents()
    suspend fun fetchPhotos(): List<GalleryItem> =
        flicker.fetchPhotos().photos.galleryItems
}