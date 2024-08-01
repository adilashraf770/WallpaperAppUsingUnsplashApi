package com.adilashraf.unsplashphotosapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiUtilities {

    const val ACCESS_KEY = "dHFRfwYmUDy_IIYvEzykTA4MPqKHAO23-youSENz_70"
    val BASE_URL = "https://api.unsplash.com/"


    fun getInstance(): PhotosApiInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhotosApiInterface::class.java)
    }



}