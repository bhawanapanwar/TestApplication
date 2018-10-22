package com.example.bhawanap.testapplication.TabLayoutModule

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.bhawanap.testapplication.FirstModule.FirstFragment
import com.example.bhawanap.testapplication.SecondModule.SecondFragment

class TabPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }
            else -> {
                return SecondFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "First Tab"
            else -> {
                return "Second Tab"
            }
        }
    }
}