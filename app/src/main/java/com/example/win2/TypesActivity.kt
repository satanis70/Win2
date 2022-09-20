package com.example.win2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.win2.model.Termin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class TypesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_types)
        getTypes()
    }

    private fun getTypes() {
        val context = this
        val api = Retrofit.Builder()
            .baseUrl("http://49.12.202.175")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            val responseTypes = api.getTypes().awaitResponse()
            if (responseTypes.isSuccessful){
                val data = responseTypes.body()!!
                launch(Dispatchers.Main) {
                    val adapter = Holder(data.typesofbets as ArrayList<Termin>, this@TypesActivity)
                    val recyclerView = findViewById<RecyclerView>(R.id.types_recycler)
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = adapter
                }
            }
        }
    }
}