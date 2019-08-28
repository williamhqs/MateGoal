package com.example.mategoal

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import java.util.concurrent.TimeUnit

class HolidayAdapter(private val holidays: JSONArray) : RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder>() {

    class HolidayViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val leftDays = view.findViewById<TextView>(R.id.left_days)
        val startDate = view.findViewById<TextView>(R.id.start_date)
        val title = view.findViewById<TextView>(R.id.title)
    }

    override fun getItemCount(): Int = holidays.length()

    override fun onBindViewHolder(p0: HolidayViewHolder, p1: Int) {

        val holiday = holidays[p1] as JSONObject
        //p0.title.text = holiday["summary"] as String
//        println(holiday)
        p0.title.text = (holiday["summary"] as String) + p1.toString()

        val start = holiday["start"].toString()

        println(start)
//        DateTimeFormatter.ISO_INSTANT.parse(start)
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(start)

        p0.startDate.text = SimpleDateFormat("yy-MM-dd").format(date)
        println(Calendar.getInstance().time)
        val now = Calendar.getInstance().time


        val msDiff = date.time - Calendar.getInstance().timeInMillis

//        println(Duration.between(date1, date2).toDays())
//        println(date1.until(date2, ChronoUnit.DAYS))
        p0.leftDays.text = TimeUnit.MILLISECONDS.toDays(msDiff).toString()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HolidayViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.holiday_item, p0, false)

        return HolidayViewHolder(view)
    }

}