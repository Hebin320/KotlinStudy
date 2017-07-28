package com.hebin.entity

/**
 * Author Hebin
 * <p>
 * created at 2017/7/25
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */
class Knowledge {

    fun loadAll() {
        println("Hebin-sum${sum()}")
        setArray()
        ranages()
        setList()
        println("Hebin${funtion()}")
    }

    // 计算数组总和
    fun sum(): Int {
        val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val result = numbers.sum()
        return result
    }

    //初始化数组、遍历数据
    fun setArray() {
        //初始化数组 array = {0,1,2,3,4,5,6,7,8,9}
        val array = Array(10, { i -> i })
        // 遍历数组子项
        for (i in array) {
            println("Hebin-setarry$i")
        }
        // 遍历数组子项
        for (i in 0..(array.size - 1)) {
            println("Hebin-setarry$i")
        }
        // 遍历数组子项
        for (i in 0..array.lastIndex) {
            println("Hebin-setarry_$i")
        }
        //根据数组下标遍历
        for (i in array.indices) {
            println("Hebin-setarry-${array[i]}")
        }
        // 反过来遍历数据（递减），输出结果：9,8,7,6,5
        for (i in array.lastIndex downTo 5) {
            println("Hebin-setarry*${array[i]}")
        }
        //反过来遍历数据（递减）,输出结果：9,8,7,6,5,4,3,2,1,0
        for (i in array.reversed()) {
            println("Hebin-setarry&${array[i]}")
        }
        //根据步长遍历数据，如步长为3，则每隔3位输出，输出结果：9,6,3,0
        for (i in array.lastIndex downTo 0 step 3) {
            println("Hebin-setarry^${array[i]}")
        }
    }

    // 包含与范围有关的函数操作符
    fun ranages() {

        if (5 in 0..10) {
            println("Hebin- 5在0-10的范围内")
        }
        if (14 !in 0..10) {
            println("Hebin- 14不在0-10的范围内")
        }

        val str = "Hello Kotlin hh"
        if (str in "Hello".."Kotlin") {
            println("Hebin-str包含两个字符串中的一个或多个")
        }
    }

    // when语句
    fun setWhen() {

        val result: Any = 78

        //判断范围、判断类型
        when (result) {
            100 -> println("Hebin-满分")
            78, 80, 90 -> println("Hebin-等于78或80或90")
            "我是谁" -> println("Hebin-我是谁")
            in 60..99 -> println("Hebin-及格")
            is Int -> println("Hebin-该字段是Int类型")
            else -> println("Hebin-该字段不是Int类型")
        }

        val list = arrayOf(1, 2, 3, 4, 5, 6)
        when {
            1 in list -> {
            }
            4 in list -> {
            }
        }
    }

    // 集合
    fun setList() {
        // list = {0,1,2,3,4,5,6,7,8,9,10}
        val list = Array(11, { i -> i })
        //any —— 判断集合中 是否有满足条件 的元素；输入结果：false
        println("Hebin${list.any({ it > 10 })}")
        //all —— 判断集合中的元素 是否都满足条件；输入结果：true
        println("Hebin${list.all { it in 0..20 }}")
        //none —— 判断集合中是否 都不满足条件，是则返回true；输入结果：true
        println("Hebin${list.none({ it > 10 })}")
        //count —— 查询集合中 满足条件 的 元素个数；输出结果：6
        println("Hebin${list.count({ it > 4 })}")
        //reduce —— 从 第一项到最后一项进行累计 ；输出结果：55
        println("Hebin${list.reduce({ total, next -> total + next })}")
        //reduceRight —— 从 最后一项到第一项进行累计；输出结果：55
        println("Hebin${list.reduceRight({ total, next -> total + next })}")
        //fold —— 与reduce类似，不过有初始值，而不是从0开始累计；输出结果：55+1=56
        println("Hebin${list.fold(1) { total, next -> total + next }}")
        //foldRight —— 和reduceRight类似，有初始值，不是从0开始累计；输出结果：55+3=58
        println("Hebin${list.foldRight(3) { total, next -> total + next }}")
        //forEach —— 循环遍历元素，元素是it，可对每个元素进行相关操作；输出结果：0,1,2,3,4,5,6,7,8,9,10
        list.forEach { println("Hebin$it") }
        println()
        //forEachIndexed —— 循环遍历元素，同时得到元素index(下标)；输出结果：(0:0),(1:1)...(10:10)
        list.forEachIndexed { index, it -> println("Hebin($index:$it)") }
        println()
        //max —— 查询最大的元素，如果没有则返回null；输出结果：10
        println("Hebin${list.max()}")
        //maxBy —— 获取方法处理后返回结果最大值对应的那个元素的初始值，如果没有则返回null；输出结果：5
        println("Hebin${list.maxBy { it * (list.size - it) }}")
        //min —— 查询最小的元素，如果没有则返回null；输出结果：0
        println("Hebin${list.min()}")
        //minBy —— 获取方法处理后返回结果最小值对应那个元素的初始值，如果没有则返回null；输出结果：0
        println("Hebin${list.minBy { it * (list.size - it) }}")
        //sumBy —— 获取 方法处理后返回结果值 的 总和；输出结果：385
        println("Hebin${list.sumBy { it * it }}")
        //drop--返回去掉前n个元素后的列表；输出结果：4,5,6,7,8,9,10
        println("Hebin${list.drop(4)}")
        //dropWhile —— 返回从第一项起，去掉满足条件的元素，直到不满足条件的一项为止；输出结果：4,5,6,7,8,9,10
        println("Hebin${list.dropWhile { it < 4 }}")
        //dropLastWhile--返回从最后一项起，去掉满足条件的元素，直到不满足条件的一项为止；输出结果：0,1,2,3,4
        println("Hebin${list.dropLastWhile { it > 4 }}")
        //take--从第一个开始的n个元素；输出结果：0,1,2,3
        println("Hebin${list.take(4)}")
        //takeLast —— 返回从最后一个开始的n个元素；输出结果：7,8,9,10
        println("Hebin${list.takeLast(4)}")
        //takeWhile--返回不满足条件的下标前面的所有元素的集合；输出结果：0,1,2,3
        println("Hebin${list.takeWhile { it < 4 }}")
        //filter--过滤掉所有不满足条件的元素；输出结果：0, 2, 4, 6, 8, 10
        println("Hebin${list.filter { it % 2 == 0 }}")
        //filterNot —— 过滤掉所有满足条件的元素；输出结果：1, 3, 5, 7, 9
        println("Hebin${list.filterNot { it % 2 == 0 }}")
        //filterNotNull--过滤掉所有值为null的元素；输出结果：0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        println("Hebin${list.filterNotNull()}")
    }

    fun funtion() {

        fun maxOf(a: Int = 100, b: Int = 89) = if (a > b) a else b

        class jj {
            fun one() {}
            fun two() {}
            fun three() {}
        }

        val j = jj()
        with(j) {
            one()
        }

    }


}