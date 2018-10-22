package com.example.bhawanap.testapplication.FirstModule

import android.view.View
import android.widget.TextView

/**
 * **  Created by home on 22-Oct-18.
 */
interface FirstView{
    fun onClick(v: View?)
    fun showRedView()
    fun showBlueView()
    fun showGreenView()
    fun showText(v: View?)
}