package com.example.servicioweb

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import java.lang.Error

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cola = Volley.newRequestQueue(this@MainActivity)
        val url ="http://192.168.1.109:3000"
        val metodo = Request.Method.GET
        val todoBien = Response.Listener<JSONArray> { response ->
            Log.e("todoBien",response.toString())
        }
        val algoMal = Response.ErrorListener { response ->
            Log.e("todoMal",response.toString())
        }

        val request = JsonArrayRequest(metodo,url,null,todoBien,algoMal)

        cola.add(request)
    }
}