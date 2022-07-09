package ru.notasi.rosmosdev

import android.os.Bundle
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import ru.notasi.rosmosdev.utils.Debugger

class MainActivity : BaseActivity() {

    private companion object {
        private val className = MainActivity::class.java.simpleName
    }

    private lateinit var analytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        analytics = Firebase.analytics
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonCrash).setOnClickListener { crash() }

        debug()
        debugMessage()
        catchCrash()
    }

    private fun debug() = Debugger.log(
        threadName = Thread.currentThread().name,
        className = className,
        methodName = object {}.javaClass.enclosingMethod?.name,
        message = "Test debug"
    )

    private fun debugMessage() = Debugger.log(message = "Test debug message")

    private fun crash(): Nothing = throw RuntimeException("Test crash")

    private fun catchCrash() = Debugger.log(
        threadName = Thread.currentThread().name,
        className = className,
        methodName = object {}.javaClass.enclosingMethod?.name,
        message = "Test debug",
        throwable = RuntimeException("Test throwable runtime exception")
    )

}