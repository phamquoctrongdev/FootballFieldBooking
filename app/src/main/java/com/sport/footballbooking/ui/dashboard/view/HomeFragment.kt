package com.sport.footballbooking.ui.dashboard.view

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.sport.footballbooking.R
import com.sport.footballbooking.ui.base.BaseActivity
import com.sport.footballbooking.databinding.HomeFragmentBinding
import com.sport.footballbooking.ui.common.ChartFormatterByWeek
import com.sport.footballbooking.ui.common.TabBarCustom
import java.util.*

class HomeFragment : Fragment(), TabBarCustom.OnChangeTabBarListener {
    private lateinit var mBinding: HomeFragmentBinding
    private lateinit var mActivity: BaseActivity
    private lateinit var mTabBar: TabBarCustom
    private lateinit var mRevenueChart: BarChart
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mActivity = activity as BaseActivity
        mBinding = HomeFragmentBinding.inflate(layoutInflater)
        
        return mBinding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity.window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    
        initialRevenueChart()
        setData()
        mTabBar = mBinding.tabBar
        mTabBar.initializeListener(this)
    }
    
    private fun initialRevenueChart(){
        mRevenueChart = mBinding.chartRevenue
        mRevenueChart.xAxis.valueFormatter = ChartFormatterByWeek()
        mRevenueChart.xAxis.granularity = 1f
        mRevenueChart.xAxis.isGranularityEnabled = true
        mRevenueChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        mRevenueChart.xAxis.labelCount = 7
        mRevenueChart.description.isEnabled = false
        setBarChartByWeek()
    }
    
    private fun createBarChartByMonth() {
        val label = resources.getString(R.string.revenue_by_vnd)
        val barDataSet = BarDataSet(generateBarEntries(), label)
        barDataSet.color = requireContext().getColor(R.color.main_color)
        val dataSets = listOf<IBarDataSet>(barDataSet)
        mRevenueChart.xAxis.labelCount = 12
        mRevenueChart.data = BarData(dataSets)
    }
    
    private fun setBarChartByWeek() {
        val label = resources.getString(R.string.revenue_by_vnd)
        val barDataSet = BarDataSet(generateBarEntriesByWeek(), label)
        barDataSet.color = requireContext().getColor(R.color.main_color)
        val dataSets = listOf<IBarDataSet>(barDataSet)
        mRevenueChart.data = BarData(dataSets)
    }
    
    
    
    //Todo: Remove this
    private fun generateBarEntries(): ArrayList<BarEntry> {
        val entries = ArrayList<BarEntry>()
        for (i in 1..12) {
            entries.add(BarEntry(i.toFloat(), Random().nextFloat() * 1000))
        }
        return entries
    }
    
    private fun generateBarEntriesByWeek(): ArrayList<BarEntry> {
        val entries = ArrayList<BarEntry>()
        for (i in 1..7) {
            entries.add(BarEntry(i.toFloat(), Random().nextFloat() * 1000))
        }
        return entries
    }
    
    private fun setData() {
        setHelloText()
        setCurrentTime()
        setRevenue()
        setPitchStatus()
    }
    
    private fun setRevenue() {
        val tvRevenue = mBinding.tvRevenue
        tvRevenue.text = "99.999.000 VND" //Todo
    }
    
    private fun setPitchStatus() {
        val tvWorkedPitch = mBinding.tvWorkedPitch
        val tvWorkingPitch = mBinding.tvWorkingPitch
        val tvEmptyPitch = mBinding.tvEmptyPitch
        tvWorkedPitch.text = "77"
        tvWorkingPitch.text = "88"
        tvEmptyPitch.text = "99"
    }
    
    private fun setHelloText() {
        val tvHello = mBinding.tvHello
        val mActivity = activity as BaseActivity
        val bundle = mActivity.intent.extras
        val username = bundle?.getString("username")
        val fullText = getString(R.string.hello, username)
        val spannable = SpannableString(fullText)
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            fullText.indexOf(",") + 1, // start
            fullText.length - 1, // end
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        spannable.setSpan(
            StyleSpan(Typeface.ITALIC),
            fullText.indexOf(",") + 1, // start
            fullText.length - 1, // end
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        tvHello.text = spannable
    }
    
    @SuppressLint("SimpleDateFormat")
    private fun setCurrentTime() {
        val calendar = Calendar.getInstance()
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        val tvFullDate = mBinding.tvFullDate
        val fullText = getString(R.string.full_date, dayOfWeek, day, month + 1, year)
        tvFullDate.text = fullText
    }
    
    override fun onChange(type: TabBarCustom.TabBarType) {
        //Todo
    }
}
