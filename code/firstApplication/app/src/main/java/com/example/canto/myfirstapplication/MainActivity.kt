package com.example.canto.myfirstapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.canto.myfirstapplication.sqlite.activities.ListCountryActivity
import com.example.canto.myfirstapplication.weigthtracker.activities.ListWeightActivity
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    var updateCount = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the Send button */
    fun daysLeftAction(view: View) {
        val intent = Intent(this, DisplayDaysLeftActivity::class.java)
        startActivity(intent)
    }

    fun pwdPageOpen(view: View) {
        val intent = Intent(this, PasswordActivity::class.java)
        startActivity(intent)
    }

    fun sqlListTest(view: View) {
        val intent = Intent(this, ListCountryActivity::class.java)
        startActivity(intent)
    }

    fun weightTracker(view: View) {
        val intent = Intent(this, ListWeightActivity::class.java)
        startActivity(intent)
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }


}
