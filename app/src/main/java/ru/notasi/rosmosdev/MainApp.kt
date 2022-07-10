package ru.notasi.rosmosdev

import android.app.Application

class MainApp : Application() {

    /**
     * https://stackoverflow.com/a/33994484
     * Measure Android app startup time.
     */

    companion object {
        val appStartTime = System.currentTimeMillis()
    }

}