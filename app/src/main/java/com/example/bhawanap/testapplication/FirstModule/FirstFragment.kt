package com.example.bhawanap.testapplication.FirstModule

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bhawanap.testapplication.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment(), FirstView,View.OnClickListener {

    private val presenter = FirstPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        view.bt_1.setOnClickListener(this)
        view.bt_2.setOnClickListener(this)
        view.bt_3.setOnClickListener(this)

        view.tx1.setOnClickListener(this)
        view.tx2.setOnClickListener(this)
        view.tx3.setOnClickListener(this)
        view.tx4.setOnClickListener(this)
        view.tx5.setOnClickListener(this)

        setupViewPager(view.viewPager)

        return view
    }

    private fun setupViewPager(pager: ViewPager?) {
        val adapter = PagerAdapter(childFragmentManager)

        val f1 = BlankFragment.newInstance("Fragment One", this)
        adapter.addFragment(f1, "TAB 1")

        val f2 = BlankFragment.newInstance("Fragment Two", this)
        adapter.addFragment(f2, "TAB 2")

        val f3 = BlankFragment.newInstance("Fragment Three", this)
        adapter.addFragment(f3, "TAB 3")

        val f4 = BlankFragment.newInstance("Fragment Four", this)
        adapter.addFragment(f4, "TAB 4")

        pager?.adapter = adapter
    }


    override fun showRedView() {
        linColor.setBackgroundColor(resources.getColor(R.color.colorAccent))
    }

    override fun showBlueView() {
        linColor.setBackgroundColor(resources.getColor(R.color.colorPrimary))
    }

    override fun showGreenView() {
        linColor.setBackgroundColor(resources.getColor(R.color.colorGreen))
    }

    override fun showText(v:View?) {
        txShowItem.text=(v as TextView).text.toString()
    }

    override fun onClick(v: View?) {

        presenter.getClick(v)
    }


}