package com.hebin.kotlin.study.ui.activity

import android.os.Bundle
import com.hebin.kotlin.study.base.BaseActivity
import com.hebin.kotlin.study.entity.DataEntity
import com.hebin.kotlin.study.entity.PhoneEntity
import com.hebin.kotlin.study.presenter.MainPresenter
import com.hebin.kotlin.study.ui.view.Mainview
import com.zerom.management.mInterface.base.UniversalView
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : BaseActivity(), UniversalView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mainview().setContentView(this)
        Mainview.btnLoad?.text = "确定"
        Mainview.btnLoad?.setOnClickListener {
            val presenter: MainPresenter = MainPresenter(this, this)
            presenter.getData_1()
        }
    }

    // 将数据传给p层
    override fun getData(): Any {
        val entity = DataEntity()
        entity.title = "我是标题"
        entity.phone = Mainview.etPhone?.text.toString()
        return entity
    }

    override fun getSuccess(type: Any, T: Any) {
        when (type) {
        // 第一个网络请求成功
            MainPresenter.GET_SUCCESS_01 -> {
                val entity: PhoneEntity = T as PhoneEntity
                startActivity<SecondActivity>(SecondActivity.INTENT_INFO to entity)
            }
        //第二个请求成功
            MainPresenter.GET_SUCCESS_02 -> {
                val info = T as String
                toast(info)
            }
        }
    }
}
