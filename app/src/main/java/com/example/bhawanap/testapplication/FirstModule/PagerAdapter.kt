package com.example.bhawanap.testapplication.FirstModule

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class PagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
    val mFragments = ArrayList<Fragment>()
    val mTitles = ArrayList<String>()
    override fun getItem(position: Int): Fragment = mFragments.get(position)

    override fun getCount(): Int = mFragments.size

    override fun getPageTitle(position: Int): CharSequence? = mTitles.get(position)

    fun addFragment(fragment: Fragment, title: String) {
        mFragments.add(fragment)
        mTitles.add(title)

    }
}
