package com.amir.argo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.isVisible

class SliderFragment : Fragment() {

    var pageTitle: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_slider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val fragment_title = view.findViewById<TextView>(R.id.fragment_title)
        fragment_title.text = pageTitle


        val background = view.findViewById<RelativeLayout>(R.id.background)


        if (fragment_title.text.equals("homepage"))
        {
            background.setBackgroundResource(R.drawable.homepage)
        }
        else if (fragment_title.text.equals("navpage"))
        {
            background.setBackgroundResource(R.drawable.navpage)
        }
        else
        {
            background.setBackgroundResource(R.drawable.detectpage)
        }
    }

    fun setTitle(title: String)
    {

        pageTitle = title
    }
}