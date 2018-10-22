package com.example.bhawanap.testapplication.SecondModule

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.bhawana.flickr.NetworkModule.ApiServices
import com.bhawana.flickr.NetworkModule.RetrofitInstance
import com.example.bhawanap.testapplication.MainApplication
import com.google.gson.JsonElement
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.json.JSONArray
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * **  Created by home on 21-Oct-18.
 */
class Iterator {

    private lateinit var apiServices: ApiServices
    private lateinit var context:Context

    fun hitApi(): Observable<List<Model>> {

        apiServices = RetrofitInstance.retrofitInstance.create(ApiServices::class.java)

        context= MainApplication.applicationContext()

        val call = apiServices.getApiData()

         val observable: PublishSubject<List<Model>> = PublishSubject.create<List<Model>>()

        call.enqueue(object : Callback<JsonElement> {

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                val result = response.body().toString()
                try {
                    lateinit var mlistArry: MutableList<Model>
                    mlistArry = mutableListOf()
                    Log.e("result1", result)
                    val jsonArray = JSONArray(result)

                       // val photos = jsonObject.getJSONObject("photos")
                       // val photo = photos.getJSONArray("photo")
                        if (jsonArray.length() > 0) {

                            for (i in 0..(jsonArray.length() - 1)) {
                                val jdata = jsonArray.getJSONObject(i)

                                val id = jdata.getString("id")
                                val name = jdata.getString("name")

                                val fromcentral = jdata.getJSONObject("fromcentral")
                                val car = fromcentral.getString("car")
                                var train=""
                                if(fromcentral.has("train")) {
                                    train = fromcentral.getString("train")
                                }

                                val location = jdata.getJSONObject("location")
                                val latitude = location.getString("latitude")
                                val longitude = location.getString("longitude")

                                mlistArry.add(Model(id, name,
                                        car, train, latitude,
                                        longitude))
                            }

                        } else {
                            Toast.makeText(context, "No data found!", Toast.LENGTH_SHORT).show()
                        }

                        observable.onNext(mlistArry)
                        observable.onComplete()


                } catch (e: JSONException) {
                    e.printStackTrace()
                    observable.onError(e)

                }

            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.e("fail", "")
                observable.onError(t)

            }
        })
        return observable
    }

}