package com.example.canto.myfirstapplication

import android.icu.text.SimpleDateFormat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*
import java.util.concurrent.TimeUnit


class DisplayDaysLeftActivity : AppCompatActivity() {
    var updateCount = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)
        val message = intent.getStringExtra(EXTRA_MESSAGE);

        setDates();

        val thread = object : Thread() {

            override fun run() {
                try {
                    while (!this.isInterrupted) {
                        Thread.sleep(3000)
                        runOnUiThread {
                            setDates();
                        }
                    }
                } catch (e: InterruptedException) {
                }

            }
        }
        thread.start()
    }

    private fun setDates() {
        val daysLeft = DaysLeft( dateToStr(Date()), "02/11/2019")
        findViewById<TextView>(R.id.textView).apply {
            text = daysLeft.formatForUi(updateCount)
        }
        updateCount++;
    }
}
