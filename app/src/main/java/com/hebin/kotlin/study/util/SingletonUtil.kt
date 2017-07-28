package com.hebin.utils

/**
 * Author Hebin
 *
 *
 * created at 2017/5/5 10:27
 *
 *
 * blog: http://blog.csdn.net/hebin320320
 *
 *
 * GitHub: https://github.com/Hebin320
 *
 *
 * 说明：泛型单例模式
 */
abstract class SingletonUtil<out T> {

    private var instance: T? = null

    protected abstract fun newInstance(): T

    fun getInstance(): T? {
        if (instance == null) {
            synchronized(SingletonUtil::class) {
                if (instance == null) {
                    instance = newInstance()
                }
            }
        }
        return instance
    }
}
