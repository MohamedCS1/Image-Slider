package com.example.imageslider

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragment: FragmentActivity, val arrayoffragment: ArrayList<Fragment>) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return  arrayoffragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return arrayoffragment[position]
    }
}