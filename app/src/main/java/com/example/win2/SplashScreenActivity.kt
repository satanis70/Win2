package com.example.win2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Html
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar_splash)
        val text = "<font color=#ffffff>WIN</font><font color=#1AF423>SPORT2</font>"
        findViewById<TextView>(R.id.text_view_splash_screen).text = Html.fromHtml(text)
        progressBar.max = 30
        splashTime(progressBar)
    }

    private fun splashTime(progressBar: ProgressBar) {
        val timerSplash = object: CountDownTimer(3000, 1000) {
            var currentProgress = 0
            override fun onTick(millisUntilFinished: Long) {
                currentProgress+=10
                progressBar.progress = currentProgress
                Log.i("current", currentProgress.toString())
            }
            override fun onFinish() {
                    val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
            }
        }
        timerSplash.start()
    }


}