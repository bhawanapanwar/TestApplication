package com.bhawana.flickr.NetworkModule



import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


/**
 * **  Created by home on 21-Oct-18.
 */
interface ApiServices {

    @Headers("Content-Type: application/json")
    @GET("sample.json")
    fun getApiData(): Call<JsonElement>
}