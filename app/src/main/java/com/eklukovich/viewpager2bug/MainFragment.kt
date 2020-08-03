package com.eklukovich.viewpager2bug

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.viewpager2_button).setOnClickListener {
            findNavController().navigate(R.id.action_main_fragment_to_ViewPager2Fragment)
        }
        view.findViewById<Button>(R.id.viewpager_button).setOnClickListener {
            findNavController().navigate(R.id.action_main_fragment_to_ViewPagerFragment)
        }
    }
}