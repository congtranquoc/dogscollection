package com.example.dogsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.dogsapp.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.text.FieldPosition

class MainActivity : AppCompatActivity(), View.OnClickListener, ViewPager.OnPageChangeListener{
    private lateinit var binding: ActivityMainBinding

    var viewPager: ViewPager? = null
    private var dotsLayout: LinearLayout? = null
    private var dots: Array<TextView?>? = null
    private var layouts: IntArray? = null

    private var images = intArrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4
    )

    private var headings = intArrayOf(
        R.string.heading_one,
        R.string.heading_two,
        R.string.heading_three,
        R.string.heading_fourth
    )

    private var descriptions = intArrayOf(
        R.string.desc_one,
        R.string.desc_two,
        R.string.desc_three,
        R.string.desc_fourth
    )
    private var viewPagerAdapter: ViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            backbtn.setOnClickListener(this@MainActivity)
            nextbtn.setOnClickListener(this@MainActivity)
            skipButton.setOnClickListener(this@MainActivity)
            
        }
        layouts = intArrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4
        )
        dotsLayout = binding.indicatorLayout
        setUpCadicator(0)
        viewPager = binding.slideViewPager
        viewPagerAdapter = ViewPagerAdapter(this, images, headings, descriptions)
        viewPager!!.adapter = viewPagerAdapter
        viewPager!!.addOnPageChangeListener(this)

    }

    override fun onClick(p0: View?) {
        if(p0 != null){
            when(p0.id){
                R.id.backbtn -> {
                    if(getItem(0) > 0){
                        viewPager?.setCurrentItem(getItem(-1), true)
                    }
                }
                R.id.nextbtn -> {
                    if (getItem(0)<3){
                        viewPager?.setCurrentItem(getItem(1), true)
                    }
                    return
                }
                R.id.skipButton -> {
                    return
                }
            }
        }
    }

    private fun setUpCadicator(position: Int){
        dots = layouts?.let { arrayOfNulls<TextView>(it.size) }
        val colorsActive = resources.getColor(R.color.active)
        val colorsInactive = resources.getColor(R.color.inactive)
        dotsLayout!!.removeAllViews()
        for (i in dots!!.indices) {
            dots!![i] = TextView(this)
            dots!![i]?.text = Html.fromHtml("&#8226;")
            dots!![i]?.textSize = 35f
            dots!![i]?.setTextColor(colorsInactive)
            dotsLayout!!.addView(dots!![i])
        }

        if (dots!!.size > 0)
            dots!![position]?.setTextColor(colorsActive)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }


    override fun onPageSelected(position: Int) {
        setUpCadicator(position)
        Log.d("MainActivyTAG", "onPageSelected: " + position)
        if (position>0){
            binding.backbtn.visibility = View.VISIBLE
        } else {
            binding.backbtn.visibility = View.INVISIBLE
        }
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    fun getItem(i: Int): Int{
        return viewPager!!.currentItem + i
    }
}

