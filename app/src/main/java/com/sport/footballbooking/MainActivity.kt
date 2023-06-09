package com.sport.footballbooking

import android.content.Intent
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.sport.footballbooking.ui.base.BaseActivity
import com.sport.footballbooking.ui.dashboard.view.DashBoardActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.main_activity
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        setupSplash()
        super.onCreate(savedInstanceState)
    }
    
    private fun setupSplash() {
        installSplashScreen()
        runBlocking {
            delay(2000)
            val intent = Intent(applicationContext, DashBoardActivity::class.java)
            intent.putExtra("username", "Footballer")
            startActivity(intent)
            finish()
        }
    }
}
