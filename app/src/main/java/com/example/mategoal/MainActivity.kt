package com.example.mategoal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val items = listOf(
        "给初学者的RxJava2.0教程（七）: Flowable",
        "Android之View的诞生之谜",
        "Android之自定义View的死亡三部曲之Measure",
        "Using ThreadPoolExecutor in Android ",
        "Kotlin 泛型定义与 Java 类似，但有着更多特性支持。",
        "Android异步的姿势，你真的用对了吗？",
        "Android 高质量录音库。",
        "Android 边缘侧滑效果，支持多种场景下的侧滑退出。"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview = findViewById(R.id.listView) as RecyclerView
        listview.layoutManager = LinearLayoutManager(this)
        listview.adapter = HolidayAdapter(items)
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