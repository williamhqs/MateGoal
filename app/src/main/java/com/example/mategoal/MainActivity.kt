package com.example.mategoal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.Response.Listener
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {
    var items = listOf(mapOf<String, Any?>())
    var holidays = JSONArray()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val listView = findViewById<RecyclerView>(R.id.listView)
        listView.layoutManager = LinearLayoutManager(this)



        val requestQueue = Volley.newRequestQueue(this)
        val url = "http://www.mategoal.com:8090/holiday/zh_cn.china"
        val request = StringRequest(url, Listener { response ->
//
//            Log.d("123", "123")
//            Log.d("123", response)
//            Json
//            val json = Json(JsonConfiguration.Stable)
            // serializing objects
//            val jsonData = json.stringify(Data.serializer(), Data(42))
//            // serializing lists
//            val jsonList = json.stringify(Data.serializer().list, listOf(Data(42)))
//            println(jsonData) // {"a": 42, "b": "42"}
//            println(jsonList) // [{"a": 42, "b": "42"}]
//
//            // parsing data back
//            val obj = json.parse(Data.serializer(), """{"a":42}""") // b is optional since it has default value
//            println(obj) // Data(a=42, b="42"

//            val holidays = JSONArray("[" + response + "]")
            val json = JSONObject(response)
            holidays = json["items"] as JSONArray
            println(holidays.length())
            val adapter =  HolidayAdapter(holidays)
            listView.adapter = adapter
//            adapter.notifyDataSetChanged()

        }, Response.ErrorListener { error ->

        })

        requestQueue.add(request)

    }
}

//Google Ad install
//Next, place the ad unit inside your app
//Follow these instructions:
//Complete the instructions in the Google Mobile Ads SDK guide using this app ID:
//MateGoalca-app-pub-6835894022327289~6430573643
//Follow the banner implementation guide to integrate the SDK. You'll specify ad type, size, and placement when you integrate the code using this ad unit ID:
//holidaysca-app-pub-6835894022327289/9744693196
//Review the AdMob policies to ensure your implementation complies.
//EMAIL INSTRUCTIONS