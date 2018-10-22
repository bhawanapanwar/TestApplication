package com.example.bhawanap.testapplication.TabLayoutModule

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.example.bhawanap.testapplication.FirstModule.FirstFragment
import com.example.bhawanap.testapplication.R
import com.example.bhawanap.testapplication.SecondModule.SecondFragment
import kotlinx.android.synthetic.main.activity_tab_layout.*

class TabLayoutActivity : AppCompatActivity() {
    private var fragmentOne: FirstFragment? = null
    private var fragmentTwo: SecondFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        bindWidgetsWithAnEvent()
        setupTabLayout()

    }

    private fun setupTabLayout() {
        fragmentOne = FirstFragment()
        fragmentTwo = SecondFragment()

        tabs.addTab(tabs.newTab().setText("ONE"), true)
        tabs.addTab(tabs.newTab().setText("TWO"))
    }

    private fun bindWidgetsWithAnEvent() {
        tabs.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                setCurrentTabFragment(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun setCurrentTabFragment(tabPosition: Int) {
        when (tabPosition) {
            0 -> replaceFragment(fragmentOne!!)
            1 -> replaceFragment(fragmentTwo!!)
        }
    }

    fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.frame_container, fragment)
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft.commit()
    }
}