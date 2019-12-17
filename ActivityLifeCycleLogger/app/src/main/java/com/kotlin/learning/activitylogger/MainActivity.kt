package com.kotlin.learning.activitylogger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    companion object {
        val log = Logger.getLogger(MainActivity::class.java.name);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log.info("onCreate() called")
    }

    override fun onStart() {
        super.onStart()
        log.info("onStart() called")
    }

    override fun onStop() {
        super.onStop()
        log.info("onStop() called")
    }

    override fun onRestart() {
        super.onRestart()
        log.info("onRestart() called")
    }

    override fun onResume() {
        super.onResume()
        log.info("onResume() called")
    }

    override fun onPause() {
        super.onPause()
        log.info("onPause() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        log.info("onDestroy() called")
    }
}
