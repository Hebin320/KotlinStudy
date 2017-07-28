package com.hebin.kotlin.study.base

import android.support.v7.app.AppCompatActivity
import com.zerom.management.mInterface.base.BaseView

/**
 * Author Hebin
 * <p>
 * created at 2017/7/27
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */
open class BaseActivity :AppCompatActivity(),BaseView {

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showNullLayout() {
    }

    override fun hideNullLayout() {
    }

    override fun showErroLayout() {
    }

    override fun hideErroLayout() {
    }

    override fun getFailed(type: Any, T: Any) {
    }
}