package com.adilashraf.unsplashphotosapi.api

import com.adilashraf.unsplashphotosapi.model.PhotosItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface PhotosApiInterface {

    @Headers("Authorization: Client-ID " + ApiUtilities.ACCESS_KEY )
    @GET("/photos")
    fun getAllPhotos(
        @Query("page")  page: Int,
        @Query("per_page")  perPage: Int,
    ): Call<List<PhotosItem>>

 


}