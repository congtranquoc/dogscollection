package com.example.dogsapp

import android.content.ClipDescription
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class ViewPagerAdapter(var context: Context,
                       var images: IntArray,
                       var headings: IntArray,
                       var descriptions: IntArray): PagerAdapter() {

    var layoutInflater: LayoutInflater

    override fun getCount(): Int {
        return headings.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view ==  `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = layoutInflater.inflate(R.layout.slider_layout, container, false)
        val imageView = view.findViewById<View>(R.id.titleImage) as ImageView
        imageView.setImageResource(images[position])

        val txt_heading = view.findViewById<TextView>(R.id.texttilte) as TextView
        txt_heading.setText(headings[position])

        val txt_desc = view.findViewById<TextView>(R.id.textDesciption) as TextView
        txt_desc.setText(descriptions[position])
        container.addView(view)
        return view
    }

    init {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}