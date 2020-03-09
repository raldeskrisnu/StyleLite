package com.stylethory.raldes.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.stylethory.raldes.module.fragment.color.ColorsFragment
import com.stylethory.raldes.module.fragment.products.ProductsFragment

class StyleTheoryLiteAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    private val pages = listOf(
        ProductsFragment(),
        ColorsFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Products"
            else -> "Colors"
        }
    }
}