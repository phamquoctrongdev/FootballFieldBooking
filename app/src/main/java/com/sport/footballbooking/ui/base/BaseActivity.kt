package com.sport.footballbooking.ui.base

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.sport.footballbooking.databinding.BaseActivityBinding

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var mLoadingProgressBar: ProgressBar
    private lateinit var mBinding: BaseActivityBinding
    abstract fun getLayoutId(): Int
    
    fun showLoading() {
        mLoadingProgressBar.visibility = View.VISIBLE
    }
    
    fun dismissLoading() {
        mLoadingProgressBar.visibility = View.GONE
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = BaseActivityBinding.inflate(layoutInflater)
        mLoadingProgressBar = mBinding.loadingProgressBar
        setContentView(mBinding.root)
        setChildView()
    }
    
    private fun setChildView() {
        val frameLayout = mBinding.mainContent
        layoutInflater.inflate(getLayoutId(), frameLayout)
    }
}
