package ru.notasi.rosmosdev

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

private val tabsTitles = arrayOf(
    "1st",
    "2nd"
)

class TabsAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount() = tabsTitles.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MainFragment.newInstance()
            1 -> CrashlyticsFragment.newInstance()
            else -> MainFragment.newInstance()
        }
    }

}