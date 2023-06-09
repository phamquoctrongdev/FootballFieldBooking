package com.sport.footballbooking.ui.common

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.ValueFormatter

class ChartFormatterByMonth : ValueFormatter() {
    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        return when (value.toInt()) {
            1 -> "1"
            2 -> "2"
            3 -> "3"
            4 -> "4"
            5 -> "5"
            6 -> "6"
            7 -> "7"
            8 -> "8"
            9 -> "9"
            10 -> "10"
            11 -> "11"
            12 -> "12"
            else -> throw IllegalArgumentException("$value is not a valid month")
        }
    }
}

class ChartFormatterByWeek : ValueFormatter() {
    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        return when (value.toInt()) {
            1 -> "T2"
            2 -> "T3"
            3 -> "T4"
            4 -> "T5"
            5 -> "T6"
            6 -> "T7"
            7 -> "CN"
            else -> throw IllegalArgumentException("$value is not a valid week")
        }
    }
}


