package com.example.canto.myfirstapplication

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_password.*

class PasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)

        val textView = findViewById<TextView>(R.id.testTextView).apply {
            text = ":):):)"
        }
    }

}
