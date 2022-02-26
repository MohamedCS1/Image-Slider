package com.example.imageslider

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayoffaragment = ArrayList<Fragment>()

        arrayoffaragment.add(ImageFragment.newInstance(R.drawable.img0))
        arrayoffaragment.add(ImageFragment.newInstance(R.drawable.img1))
        arrayoffaragment.add(ImageFragment.newInstance(R.drawable.img2))
        arrayoffaragment.add(ImageFragment.newInstance(R.drawable.img3))
        arrayoffaragment.add(ImageFragment.newInstance(R.drawable.img4))
        arrayoffaragment.add(ImageFragment.newInstance(R.drawable.img5))
        arrayoffaragment.add(ImageFragment.newInstance(R.drawable.img6))
        arrayoffaragment.add(ImageFragment.newInstance(R.drawable.img7))
        arrayoffaragment.add(ImageFragment.newInstance(R.drawable.img8))
        arrayoffaragment.add(ImageFragment.newInstance(R.drawable.img9))

        val textcounter = findViewById<TextView>(R.id.textview_image_counter)

        val pageradapter = PagerAdapter(this ,arrayoffaragment)

        val viewpager2 = findViewById<ViewPager2>(R.id.myviewpager)

        val tablayout = findViewById<TabLayout>(R.id.mytablayout)

        tablayout.setBackgroundResource(android.R.color.transparent)

        viewpager2.setPageTransformer(ZoomOutPageTransformer())

        viewpager2.adapter = pageradapter

        viewpager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            @SuppressLint("SetTextI18n")
            override fun onPageSelected(position: Int) {
                textcounter.text = "${position+1} /${arrayoffaragment.size}"
                super.onPageSelected(position)
            }
        })

        TabLayoutMediator(tablayout ,viewpager2 ,object :TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.setIcon(R.drawable.circle_background)

            }

        }).attach()
    }
}