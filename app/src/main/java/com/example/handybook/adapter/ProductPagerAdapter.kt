package com.example.handybook.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.handybook.SCREEN.ProductItemFragment

class ProductPagerAdapter(fa: FragmentActivity, val list: MutableList<String>) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return ProductItemFragment.newInstance(list[position])
    }
}