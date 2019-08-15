package com.example.mategoal

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

class HolidayAdapter(private val holidays: List<String>) : RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder>() {

    class HolidayViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView) {}

    override fun getItemCount(): Int = holidays.size

    override fun onBindViewHolder(p0: HolidayViewHolder, p1: Int) {
        p0.textView.text = holidays[p1]
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HolidayViewHolder {
        return HolidayViewHolder(TextView(p0.context))
    }

}