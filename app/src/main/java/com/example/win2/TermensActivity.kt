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

class TermensActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_termens)

        val text = "<font color=#ffffff>WIN</font><font color=#1AF423>SPORT2</font>"
        findViewById<TextView>(R.id.text_view_termens).text = Html.fromHtml(text)

        getTermens()
    }

    private fun getTermens() {
        val context = this
        val api = Retrofit.Builder()
            .baseUrl("http://49.12.202.175")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            val responseTermens = api.getTermens().awaitResponse()
            if (responseTermens.isSuccessful){
                val data = responseTermens.body()!!
                Log.i("termens", data.termins.toString())
                launch(Dispatchers.Main) {
                    val adapter = Holder(data.termins as ArrayList<Termin>, this@TermensActivity)
                    val recyclerView = findViewById<RecyclerView>(R.id.termens_recycler)
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = adapter
                }
            }
        }

    }
}