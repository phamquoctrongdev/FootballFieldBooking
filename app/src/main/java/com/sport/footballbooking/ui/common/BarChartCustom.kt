package com.sport.footballbooking.ui.common

import android.content.Context
import android.util.AttributeSet
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis

class BarChartCustom(context: Context, attrs: AttributeSet) : BarChart(context, attrs) {
    init {
        xAxis.valueFormatter = ChartFormatterByMonth()
        xAxis.granularity = 1f
        xAxis.isGranularityEnabled = true
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.labelCount = 12
        axisLeft.labelCount = 12
        description.isEnabled = false
    }
}
