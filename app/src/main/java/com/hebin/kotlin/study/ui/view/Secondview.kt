package com.hebin.kotlin.study.ui.view

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView
import com.hebin.kotlin.study.R
import com.hebin.ui.viewholder.simpleTitle
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
class Secondview : AnkoComponent<Activity> {

    companion object {
        var tvInfo: TextView? = null
    }

    @SuppressLint("RtlHardcoded")
    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        // verticalLayout相当于垂直方向的LinearLayout
        verticalLayout {
            // dip 是将dp转换为px，px2dip是将px转换为dp，px2sp是将px转换为sp
            backgroundColor = Color.parseColor("#E2DDDD")

            lparams {
                width = matchParent
                height = matchParent
            }

            simpleTitle()

            tvInfo = textView  {
                textSize = 16f
                textColor = resources.getColor(R.color.colorPrimary)
                gravity = Gravity.CENTER
            }.lparams {
                width = matchParent
                height = matchParent
            }
        }
    }

}