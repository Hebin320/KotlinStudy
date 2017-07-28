package com.hebin.kotlin.study.base

import android.util.Log

/**
 * Author Hebin
 * <p>
 * created at 2017/7/28
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */
class Baseurl {
    companion object {

        /**
         *  查询号码归属地
         * */
        fun searchPhoneLocation(pbone: String): String {
            val string = "http://apis.juhe.cn/mobile/get?phone=$pbone&key=2431d292750493e2ca642d2ceb736f84"
            printData(string)
            return string
        }

        fun printData(string: String) {
            Log.e("Hebin", string)
        }
    }
}