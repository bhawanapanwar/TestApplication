package com.example.bhawanap.testapplication.SecondModule

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bhawanap.testapplication.R
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_second.*
import android.widget.AdapterView


class SecondFragment : Fragment(), SecondView {

    private val presenter = Presenter(this, Iterator())
    private val nameList = ArrayList<String>()
    private val mlist =ArrayList<Model>()
    private var position:Int=0
    private lateinit var spinnerAdapter:ArrayAdapter<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)


        spinnerAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, nameList)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        presenter.getData()


        return view
    }

    override fun updateData(list: List<Model>) {
        nameList.clear()
        mlist.clear()
        mlist.addAll(list)

        for (i in 0 until mlist.size) {
            Log.e("name",mlist[i].name)
            nameList.add(mlist[i].name)
        }

        getInit()

    }

    private fun getInit(){

        spinner.adapter = spinnerAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                txCar.text = resources.getString(R.string.car) + " " + mlist[p2].car
                txTrain.text = resources.getString(R.string.train) + " " + mlist[p2].train
                position=p2
            }

        }

        btNavigate.setOnClickListener{
            presenter.getMap(mlist[position].latitude,mlist[position].longitude)
        }
    }



}