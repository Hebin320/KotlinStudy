package com.hebin.ui.viewholder


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.ViewManager
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.hebin.kotlin.study.R
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView

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
@Suppress("DEPRECATION")
@SuppressLint("StaticFieldLeak")
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class SimpleTitle : RelativeLayout {

    companion object {
        var ivBack: ImageView? = null
        var tvTitle: TextView? = null
    }


    @SuppressLint("ResourceType")
    private fun init() = AnkoContext.createDelegate(this).apply {


        relativeLayout {
            lparams {
                width = matchParent
                height = dip(50)
            }
            backgroundColor = resources.getColor(R.color.colorPrimary)

            ivBack = imageView {
                scaleType = ImageView.ScaleType.CENTER
                imageResource = R.drawable.ic_back_white
            }.lparams {
                width = dip(50)
                height = matchParent
            }

            tvTitle = textView("我是标题") {
                textSize = 20f
                textColor = Color.WHITE
            }.lparams {
                centerInParent()
            }
        }
    }

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun ViewManager.simpleTitle() = simpleTitle({})

inline fun ViewManager.simpleTitle(init: SimpleTitle.() -> Unit, theme: Int = 0) = ankoView(::SimpleTitle, theme, init)