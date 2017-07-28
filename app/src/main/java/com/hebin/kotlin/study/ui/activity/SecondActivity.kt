package com.hebin.kotlin.study.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hebin.kotlin.study.entity.PhoneEntity
import com.hebin.kotlin.study.ui.view.Secondview
import com.hebin.ui.viewholder.SimpleTitle
import org.jetbrains.anko.setContentView

class SecondActivity : AppCompatActivity() {

    companion object {
        val INTENT_INFO = "INTENT_INFO"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Secondview().setContentView(this)
        val entity: PhoneEntity = intent.getSerializableExtra(INTENT_INFO) as PhoneEntity
        Secondview.tvInfo?.text = "省份：${entity.result.province}\n城市：${entity.result.city}\n区号：${entity.result.areacode}\n邮编：${entity.result.zip}"
        SimpleTitle.ivBack?.setOnClickListener { finish() }
    }
}
