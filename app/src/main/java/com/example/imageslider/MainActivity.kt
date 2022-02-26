package com.example.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
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

        val pageradapter = PagerAdapter(this ,arrayoffaragment)

        val viewpager2 = findViewById<ViewPager2>(R.id.myviewpager)

        val tablayout = findViewById<TabLayout>(R.id.mytablayout)

        viewpager2.adapter = pageradapter

        TabLayoutMediator(tablayout ,viewpager2 ,object :TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.text = position.toString()
            }

        }).attach()
    }
}