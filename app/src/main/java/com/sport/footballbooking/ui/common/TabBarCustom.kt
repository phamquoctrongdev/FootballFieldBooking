package com.sport.footballbooking.ui.common

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.sport.footballbooking.R

class TabBarCustom(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    private var tvByWeek: TextView
    private var tvByMonth: TextView
    private var tvByYear: TextView
    private lateinit var listener: OnChangeTabBarListener
    
    fun initializeListener(listener: OnChangeTabBarListener){
        this.listener = listener
    }
    
    
    init {
        inflate(context, R.layout.tab_bar_custom, this)
        tvByWeek = findViewById(R.id.tv_by_week)
        tvByMonth = findViewById(R.id.tv_by_month)
        tvByYear = findViewById(R.id.tv_by_year)
        setActive(tvByWeek)
        tvByWeek.setOnClickListener {
            setActive(tvByWeek)
            setInactive(tvByMonth)
            setInactive(tvByYear)
            listener.onChange(TabBarType.BY_WEEK)
        }
        tvByMonth.setOnClickListener {
            setActive(tvByMonth)
            setInactive(tvByWeek)
            setInactive(tvByYear)
            listener.onChange(TabBarType.BY_MONTH)
        }
        tvByYear.setOnClickListener {
            setActive(tvByYear)
            setInactive(tvByMonth)
            setInactive(tvByWeek)
            listener.onChange(TabBarType.BY_YEAR)
        }
    }
    
    private fun setActive(view: TextView) {
        view.background = ResourcesCompat.getDrawable(resources, R.drawable.bg_tab_bar_active, null)
        view.setTextColor(Color.BLUE)
    }
    
    private fun setInactive(view: TextView) {
        view.background = null
        view.setTextColor(Color.GRAY)
    }
    
    interface OnChangeTabBarListener{
        fun onChange(type: TabBarType)
    }
    
    enum class TabBarType{
        BY_WEEK,
        BY_MONTH,
        BY_YEAR,
    }
}
