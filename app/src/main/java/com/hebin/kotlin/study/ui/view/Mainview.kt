package com.hebin.kotlin.study.ui.view

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import com.hebin.kotlin.study.R
import org.jetbrains.anko.*

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
@SuppressLint("StaticFieldLeak")
class Mainview : AnkoComponent<Activity> {

    companion object {
        var btnLoad: Button? = null
        var etPhone: EditText? = null
    }

    @SuppressLint("RtlHardcoded")
    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        // verticalLayout相当于垂直方向的LinearLayout
        relativeLayout {
            // dip 是将dp转换为px，px2dip是将px转换为dp，px2sp是将px转换为sp
            backgroundColor = Color.parseColor("#E2DDDD")

            lparams {
                width = matchParent
                height = matchParent
            }

            etPhone = editText {
                hint = "请输入手机号码"
                hintTextColor = Color.GRAY
                backgroundColor = Color.WHITE
                leftPadding = 10
                gravity = Gravity.CENTER and Gravity.LEFT

            }.lparams {
                width = matchParent
                height = dip(50)
                topMargin = dip(100)
            }


            btnLoad = button("登录") {
                textSize = 16f
                textColor = Color.WHITE
                backgroundColor = resources.getColor(R.color.colorPrimary)
            }.lparams {
                width = matchParent
                height = dip(50)
                alignParentBottom()
            }
        }
    }

}