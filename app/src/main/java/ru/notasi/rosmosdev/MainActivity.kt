package ru.notasi.rosmosdev

import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import ru.notasi.rosmosdev.databinding.ActivityMainBinding
import ru.notasi.rosmosdev.utils.Debugger

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private companion object {
        private val className = MainActivity::class.java.simpleName
    }

    private lateinit var analytics: FirebaseAnalytics

    override fun inflateLayout(inflater: LayoutInflater) =
        ActivityMainBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics = Firebase.analytics
        initTabs()
        debug()
        debugMessage()
        catchCrash()
    }

    private fun initTabs() = with(binding) {
        pager.adapter = TabsAdapter(this@MainActivity)

        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.text = "Tab $position"
        }.attach()
    }

    private fun debug() = Debugger.log(
        threadName = Thread.currentThread().name,
        className = className,
        methodName = object {}.javaClass.enclosingMethod?.name,
        message = "Test debug"
    )

    private fun debugMessage() = Debugger.log(message = "Test debug message")


    private fun catchCrash() = Debugger.log(
        threadName = Thread.currentThread().name,
        className = className,
        methodName = object {}.javaClass.enclosingMethod?.name,
        message = "Test debug",
        throwable = RuntimeException("Test throwable runtime exception")
    )

}