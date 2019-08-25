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

class HolidayAdapter(private val holidays: JSONArray) : RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder>() {

    class HolidayViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val leftDays = view.findViewById<TextView>(R.id.left_days)
        val title = view.findViewById<TextView>(R.id.title)
    }

    override fun getItemCount(): Int = holidays.length()

    override fun onBindViewHolder(p0: HolidayViewHolder, p1: Int) {

        val holiday = holidays[p1] as JSONObject
        //p0.title.text = holiday["summary"] as String
        p0.title.text = (holiday["summary"] as String) + p1.toString()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HolidayViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.holiday_item, p0, false)

        return HolidayViewHolder(view)
    }

}