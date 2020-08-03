package com.eklukovich.viewpager2bug

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.coroutines.*

class ViewPagerFragment : Fragment(R.layout.viewpager_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewPager = view.findViewById<ViewPager>(R.id.pager)
        viewPager.adapter = ViewPagerAdapter(parentFragmentManager)

        GlobalScope.launch {
            // Delay to represent wait for fetch from storage or network
            delay(50)

            withContext(Dispatchers.Main) {
                (viewPager.adapter as ViewPagerAdapter).items =
                    listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            }
        }
    }

    private class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        var items: List<Int> = listOf()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        override fun getCount(): Int = items.size

        override fun getItem(position: Int): Fragment {
            val item = items[position]
            return DemoFragment.newInstance(item)
        }
    }
}