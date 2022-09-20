package com.example.win2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.TextView

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val text = "<font color=#ffffff>WIN</font><font color=#1AF423>SPORT2</font>"
        findViewById<TextView>(R.id.text_view_info).text = Html.fromHtml(text)
        val titleInfo = intent.getStringExtra("title")
        val textInfo = intent.getStringExtra("text")
        val textViewTitle = findViewById<TextView>(R.id.text_view_title_info)
        val textViewText = findViewById<TextView>(R.id.text_view_text_info)
        textViewTitle.text = titleInfo
        textViewText.text = textInfo
    }
}