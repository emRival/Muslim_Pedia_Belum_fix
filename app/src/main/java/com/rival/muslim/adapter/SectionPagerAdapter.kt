package com.rival.muslim.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rival.muslim.ui.home.AboutAlQuranFragment
import com.rival.muslim.ui.home.AlJazeeraFragment
import com.rival.muslim.ui.home.CommonFragment
import com.rival.muslim.ui.home.WarningForMuslimFragment

class SectionPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CommonFragment()
            1 -> AboutAlQuranFragment()
            2 -> AlJazeeraFragment()
            3 -> WarningForMuslimFragment()
            else -> CommonFragment()
        }
    }
}