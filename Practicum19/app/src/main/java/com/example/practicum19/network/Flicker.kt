package com.example.practicum19.network

import retrofit2.http.GET

private const val API_KEY = "6c5ee9e4bb2833f563436c07ec77c847"
interface Flicker {
    @GET("/")
    suspend fun fetchContents(): String

    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api+key=$API_KEY" + "&format=json" + "&nojsoncallback=1" + "&extras=url_s")
    suspend fun fetchPhotos(): FlickerResponse
}