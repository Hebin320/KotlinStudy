package com.hebin.kotlin.study.presenter

import android.content.Context
import com.google.gson.Gson
import com.hebin.kotlin.study.base.Baseurl
import com.hebin.kotlin.study.entity.DataEntity
import com.hebin.kotlin.study.entity.PhoneEntity
import com.zerom.management.base.okgo.BaseOkgoGet
import com.zerom.management.base.okgo.BaseOkgoPost
import com.zerom.management.mInterface.base.SuccessListener
import com.zerom.management.mInterface.base.UniversalView
import org.jetbrains.anko.toast
import org.json.JSONObject

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
class MainPresenter(private val context: Context, private val view: UniversalView) : SuccessListener {

    companion object {
        val GET_SUCCESS_01 = 1
        val GET_SUCCESS_02 = 2
    }

    private val entity: DataEntity = view.getData() as DataEntity

    fun getData_1() {
        if (entity.phone.isEmpty()) {
            context.toast("手机号码不能为空")
        } else {
            BaseOkgoGet.getData(context, GET_SUCCESS_01, Baseurl.searchPhoneLocation(entity.phone), view, this)
        }
    }

    fun getData_2() {
        val map = hashMapOf("id" to "", "title" to "")
        BaseOkgoPost.getData(context, GET_SUCCESS_02, "url", map, view, this)
    }


    override fun onSuccess(context: Context, type: Any, results: String) {
        when (type) {
            GET_SUCCESS_01 -> {
                val json = JSONObject(results)
                if ("200" == json.getString("resultcode")) {
                    val entity: PhoneEntity = Gson().fromJson(results, PhoneEntity::class.java)
                    view.getSuccess(GET_SUCCESS_01, entity)
                }
            }
            GET_SUCCESS_02 -> {
                view.getSuccess(GET_SUCCESS_02, "我是第二个请求")
            }
        }
    }
}