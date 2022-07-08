package ru.notasi.rosmosdev

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import ru.notasi.rosmosdev.utils.Debugger

private const val className = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var analytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )

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