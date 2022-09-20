package com.example.win2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.win2.model.Termin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class DifferentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_different)

        val text = "<font color=#ffffff>WIN</font><font color=#1AF423>SPORT2</font>"
        findViewById<TextView>(R.id.text_view_diff).text = Html.fromHtml(text)

        getDifferent()
    }

    private fun getDifferent() {
        val context = this
        val api = Retrofit.Builder()
            .baseUrl("http://49.12.202.175")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            val responseTermens = api.getDifferent().awaitResponse()
            if (responseTermens.isSuccessful){
                val data = responseTermens.body()!!
                Log.i("termens", data.different.toString())
                launch(Dispatchers.Main) {
                    val adapter = Holder(data.different as ArrayList<Termin>, this@DifferentActivity)
                    val recyclerView = findViewById<RecyclerView>(R.id.diff_recycler)
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = adapter
                }
            }
        }
    }
}