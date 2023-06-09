package com.sport.footballbooking.ui.dashboard.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.sport.footballbooking.R
import com.sport.footballbooking.ui.base.BaseActivity
import com.sport.footballbooking.databinding.DashboardActivityBinding

class DashBoardActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.dashboard_activity
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = DashboardActivityBinding.inflate(layoutInflater)
        val bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                }
                R.id.history -> {
                    loadFragment(HistoryFragment())
                }
                R.id.notification -> {
                    loadFragment(HomeFragment())
                }
                R.id.profile -> {
                    loadFragment(HistoryFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
        super.onCreate(savedInstanceState)
        loadFragment(HomeFragment())
    
    }
//    override fun onStart() {
//        super.onStart()
//        val binding = DashboardActivityBinding.inflate(layoutInflater)
////        val layoutParams: CoordinatorLayout.LayoutParams =
////            bottomNavigationView.layoutParams as CoordinatorLayout.LayoutParams
////        layoutParams.behavior = BottomNavigationBehavior()
//
//    }
    private fun loadFragment(fragment: Fragment) {
        val fcv = DashboardActivityBinding.inflate(layoutInflater)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(fcv.fcvDashboard.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
