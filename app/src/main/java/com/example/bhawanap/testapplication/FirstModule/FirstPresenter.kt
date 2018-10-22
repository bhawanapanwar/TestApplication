package com.example.bhawanap.testapplication.FirstModule

import android.view.View
import com.example.bhawanap.testapplication.R

class FirstPresenter(var testView: FirstView) {

    fun getClick(v: View?){
        when (v?.id) {
            R.id.bt_1 -> {
                testView.showRedView()
            }
            R.id.bt_2 -> {
                testView.showBlueView()
            }
            R.id.bt_3 -> {
                testView.showGreenView()
            }
            R.id.tx1 -> {
                testView.showText(v)
            }
            R.id.tx2 -> {
                testView.showText(v)
            }
            R.id.tx3 -> {
                testView.showText(v)
            }
            R.id.tx4 -> {
                testView.showText(v)
            }
            R.id.tx5 -> {
                testView.showText(v)
            }
        }

    }

}

