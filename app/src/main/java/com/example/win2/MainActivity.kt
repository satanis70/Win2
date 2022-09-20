package com.example.win2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.onesignal.OneSignal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId("714b9f14-381d-4fc4-a93c-28d480557381")

        val text = "<font color=#ffffff>WIN</font><font color=#1AF423>SPORT2</font>"
        findViewById<TextView>(R.id.text_view_main).text = Html.fromHtml(text)
        val buttonTermens = findViewById<AppCompatButton>(R.id.button_termens)
        val buttonTypes = findViewById<AppCompatButton>(R.id.button_types)
        val buttonDifferents = findViewById<AppCompatButton>(R.id.button_differents)
        buttonTermens.setOnClickListener {
            startActivity(Intent(this, TermensActivity::class.java))
        }
        buttonTypes.setOnClickListener {
            startActivity(Intent(this, TypesActivity::class.java))
        }
        buttonDifferents.setOnClickListener {
            startActivity(Intent(this, DifferentActivity::class.java))
        }

    }
}