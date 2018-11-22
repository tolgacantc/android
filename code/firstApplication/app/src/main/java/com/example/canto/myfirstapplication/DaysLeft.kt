package com.example.canto.myfirstapplication

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun dateToStr(date:Date): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy")
    return sdf.format(date)
}

fun advanceDate(date: Date, type: Int, cnt: Int): Date {
    var c = Calendar.getInstance();
    c.setTime(date);
    c.add(type, cnt);
    return c.getTime();
}

class DaysLeft {
    var endDateStr: String
    var daysLeft: Long
    var diffYear: Int
    var diffMonth: Int
    var daysLeftInMonth:Long = 0;

    constructor(todayStr: String, endDateStr: String) {
        this.endDateStr = endDateStr
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val endDate = sdf.parse(this.endDateStr)
        val today = sdf.parse(todayStr);
        var diff = endDate.getTime() - today.getTime()
        this.daysLeft = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        var todayCopy = sdf.parse(todayStr)
        this.diffYear = 0
        while(advanceDate(todayCopy, Calendar.YEAR, ++this.diffYear) < endDate);
        this.diffYear--
        var startDateSameYear = advanceDate(todayCopy, Calendar.YEAR, this.diffYear);
        this.diffMonth = 0
        while(advanceDate(startDateSameYear, Calendar.MONTH, ++this.diffMonth) < endDate);
        this.diffMonth--
        var startDateSameYearSameMonth = advanceDate(startDateSameYear, Calendar.MONTH, this.diffMonth);
        diff = endDate.time - startDateSameYearSameMonth.time
        this.daysLeftInMonth = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
    }

    fun formatForUi(updateCount: Int): String {
        return """
                | Target Date : ${endDateStr}
                | Days Left :  ${daysLeft}
                | Years Left : ${diffYear}
                | Months Left : ${diffMonth}
                | Days Left In Month : ${daysLeftInMonth}
                | Update Count: $updateCount """.trimMargin();
    }
}