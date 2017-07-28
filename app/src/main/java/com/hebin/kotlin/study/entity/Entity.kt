package com.hebin.kotlin.study.entity

import java.io.Serializable

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

data class DataEntity(var phone: String, var title: String) {
    constructor() : this("", "")
}

data class PhoneEntity(var resultcode: String, var reason: String, var error_code: String, val result: ResultEntity):Serializable {

    data class ResultEntity(var province: String, var city: String, var areacode: String, var zip: String, var company: String, var card: String):Serializable
}

