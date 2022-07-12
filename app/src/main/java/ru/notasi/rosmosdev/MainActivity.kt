package ru.notasi.rosmosdev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import ru.notasi.rosmosdev.databinding.ActivityMainBinding
import ru.notasi.rosmosdev.utils.Debugger

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var analytics: FirebaseAnalytics

    override fun inflateLayout(inflater: LayoutInflater) =
        ActivityMainBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        val contentView = findViewById<View>(android.R.id.content)
        contentView.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {

            override fun onGlobalLayout() {
                contentView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                val appLaunchTime = System.currentTimeMillis() - MainApp.appStartTime
                Debugger.log("App launch time: $appLaunchTime")
            }

        })
        super.onCreate(savedInstanceState)

        analytics = Firebase.analytics
        initTabs()
    }

    private fun initTabs() = with(binding) {
        pager.adapter = TabsAdapter(this@MainActivity)

        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.text = "Tab $position"
        }.attach()
    }

}