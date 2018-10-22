package com.example.bhawanap.testapplication.SecondModule

import android.content.Context
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import com.example.bhawanap.testapplication.MainApplication
import com.example.bhawanap.testapplication.MapModule.MapActivity


/**
 * **  Created by home on 21-Oct-18.
 */
class Presenter(var secondView: SecondView, val iteractor: Iterator) {

    fun getData() {

        iteractor.hitApi().subscribeWith(DataObserver(secondView))
    }

    fun getMap(lat: String,long: String, context: Context){

        val intent = Intent(context, MapActivity::class.java)
        intent.putExtra("lat",lat)
        intent.putExtra("long",long)
        context.startActivity(intent)
    }

}

