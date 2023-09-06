package com.example.newsappcompose.util

import android.annotation.SuppressLint
import android.util.Log
import java.text.SimpleDateFormat
import java.util.Calendar

object TimeAgo {
    const val monthAgo = " month ago"
    const val weekAgo = " week ago"
    const val daysAgo = " days ago"
    const val hoursAgo = " hour ago"
    const val minAgo = " minute ago"
    const val secAgo = " seconds ago"
    var second = 1000 // milliseconds
    var minute = 60
    var hour = minute * 60
    var day = hour * 24
    var week = day * 7
    var month = day * 30
    var year = month * 12

    @SuppressLint("SimpleDateFormat")
    fun DateDifference(date: String): String {
        var fromDate: Long = convertDateToLong(date = date)
        var diff: Long = 0
        val ms2 = System.currentTimeMillis()
        // get difference in milli seconds
        diff = ms2 - fromDate
        val diffInSec = Math.abs((diff / second).toInt())
        var difference = ""
        if (diffInSec < minute) {
            difference = diffInSec.toString() + secAgo
        } else if (diffInSec / hour < 1) {
            difference = (diffInSec / minute).toString() + minAgo
        } else if (diffInSec / day < 1) {
            difference = (diffInSec / hour).toString() + hoursAgo
        } else if (diffInSec / week < 1) {
            difference = (diffInSec / day).toString() + daysAgo
        } else if (diffInSec / month < 1) {
            difference = (diffInSec / week).toString() + weekAgo
        } else if (diffInSec / year < 1) {
            difference = (diffInSec / month).toString() + monthAgo
        } else {
            // return date
            val c = Calendar.getInstance()
            c.timeInMillis = fromDate
            val format_before = SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss"
            )
            difference = format_before.format(c.time)
        }
        Log.e("time difference is: ", "" + difference)
        return difference
    }
}

fun convertDateToLong(date: String): Long {
    val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    return df.parse(date).time
}
