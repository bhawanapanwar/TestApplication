package com.bhawana.flickr.NetworkModule

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * **  Created by home on 21-Oct-18.
 */
object RetrofitInstance {

    private var retrofit: Retrofit? = null
    val BASE_URL = "http://express-it.optusnet.com.au/"

    val retrofitInstance: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit!!
        }
}