package com.example.canto.myfirstapplication

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat
import java.util.*

class DaysLeftTest {
    val sdf = SimpleDateFormat("dd/MM/yyyy")
    val todayStr = "30/06/2018"
    val today = sdf.parse("30/06/2018")

    @Test
    fun tomorrow_test() {
        val tomorrow = getTomorrow()
        val tomorrowStr = dateToStr(tomorrow)
        var daysLeft = DaysLeft(todayStr, tomorrowStr)
        assertEquals(1, daysLeft.daysLeft)
        assertEquals(0, daysLeft.diffMonth)
        assertEquals(0, daysLeft.diffYear)
        assertEquals(1, daysLeft.daysLeftInMonth)
    }

    @Test
    fun one_year_test() {
        val nextYearStr = dateToStr(getNextYear())
        var daysLeft = DaysLeft(todayStr, nextYearStr)
        assertEquals(11, daysLeft.diffMonth)
        assertEquals(0, daysLeft.diffYear)
        assertEquals(31, daysLeft.daysLeftInMonth)
        assertEquals(365, daysLeft.daysLeft)
    }

    @Test
    fun less_than_one_year_test() {
        val today = Date()
        val nextYearStr = dateToStr(advanceDate(today, Calendar.DATE, 360))
        var daysLeft = DaysLeft(dateToStr(today), nextYearStr)
        assertEquals(11, daysLeft.diffMonth)
        assertEquals(0, daysLeft.diffYear)
        assertEquals(360, daysLeft.daysLeft)
        assertEquals(26, daysLeft.daysLeftInMonth)
    }

    @Test
    fun twenty_days_test() {
        val today = Date()
        val nextYearStr = dateToStr(advanceDate(today, Calendar.DATE, 20))
        var daysLeft = DaysLeft(dateToStr(today), nextYearStr)
        assertEquals(0, daysLeft.diffMonth)
        assertEquals(0, daysLeft.diffYear)
        assertEquals(20, daysLeft.daysLeft)
        assertEquals(20, daysLeft.daysLeftInMonth)
    }

    @Test
    fun one_year_one_month_one_day_test() {
        val today = Date()
        val targetDate = dateToStr(advanceDate(advanceDate(advanceDate(today, Calendar.YEAR, 1), Calendar.MONTH, 1), Calendar.DATE, 1))
        var daysLeft = DaysLeft(dateToStr(today), targetDate)
        assertEquals(1, daysLeft.diffMonth)
        assertEquals(1, daysLeft.diffYear)
        assertEquals(396, daysLeft.daysLeft)
        assertEquals(1, daysLeft.daysLeftInMonth)
    }

    fun getNextYear(): Date {
        var dt = today
        var c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.YEAR, 1);
        return c.getTime();
    }

    fun getTomorrow(): Date {
        var dt = today
        var c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }
}