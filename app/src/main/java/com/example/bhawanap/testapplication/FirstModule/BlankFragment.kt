package com.example.bhawanap.testapplication.FirstModule

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.bhawanap.testapplication.MainApplication
import com.example.bhawanap.testapplication.R
import kotlinx.android.synthetic.main.fragment_blank.view.*

@SuppressLint("ValidFragment")
class BlankFragment(testView: FirstView) : Fragment(),View.OnClickListener {

    var st_text = ""
    lateinit var page:View

    companion object {
        fun newInstance(text: String,testView: FirstView): BlankFragment {
            val fragment = BlankFragment(testView)
            val bundle = Bundle()
            bundle.putString("Text", text)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        st_text = arguments?.get("Text").toString()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
         page = inflater.inflate(R.layout.fragment_blank, container, false)
        page.frame.setOnClickListener (this)

        return page
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.textView.text=st_text
    }

    override fun onClick(v: View?) {
        Toast.makeText(MainApplication.applicationContext(),"$st_text", Toast.LENGTH_SHORT).show()
    }

}