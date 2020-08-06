package com.eklukovich.viewpager2bug

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.*


class ViewPager2Fragment : Fragment(R.layout.viewpager2_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewPager = view.findViewById<ViewPager2>(R.id.pager2)
        val adapter = ViewPager2Adapter(this).also {
            viewPager.adapter = it
        }

        GlobalScope.launch {

            // Delay to represent wait for fetch from storage or network
            delay(50)

            withContext(Dispatchers.Main) {
                adapter.items = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            }
        }
    }

    private class ViewPager2Adapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        var items: List<Int> = listOf()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        override fun getItemCount(): Int = items.size

        override fun createFragment(position: Int): Fragment {
            val item = items[position]
            return DemoFragment.newInstance(item)
        }
    }
}