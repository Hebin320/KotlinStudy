# KotlinStudy
<h2>kotlin项目的创建</h2>
   Android Studio 3.0以后的版本，是默认支持kotlin的，创建新项目的时候，会自动添加kotlin的支持；
   创建项目成功，在module的build.gradle的顶部会添加
```
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
```
并且，在dependencies中会添加以下代码，（其中$kotlin_version是版本号，写在project的gradle中）

```
compile "org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version"
```
然后，在project的build.gradle中，会添加以下代码

```
 // 版本号
 ext.kotlin_version = '1.1.2-4'

   dependencies {
        classpath 'com.android.tools.build:gradle:2.3.0'
        classpath 'com.jfrog.bintray.gradle:gradle-bintray-plugin:1.7'
        classpath 'com.github.dcendents:android-maven-gradle-plugin:1.5'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    }
```
至此，就可以在项目中创建kotlin的文件了
</br>
<h2>为什么kotlin写代码很简洁？</h2>
   kotlin的基础语法可以才kotlin的官方文档学习，也可以通过   [kotlin官方文档中文版](https://huanglizhuo.gitbooks.io/kotlin-in-chinese/content/Basics/Packages.html)；
   </br>
   每个人都知道kotlin相比Java，代码量会减少3倍，但是，在哪个方面会减少代码量呢？以下几点可以做到：
   

<h4> 1. 无须再findviewbyid</h4>
   布局还是一样，使用xml作为Activity的布局，布局中有个TextView，ID为tvTitle；
   

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.hebin.kotlin.study.ui.MainActivity">

    <TextView
        android:id="@+id/tvTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        />

</LinearLayout>

```
然后在Activity中，通过import，声明布局即可拿到ID进行操作；

```
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTitle.setOnClickListener { toast("点击了标题") }
    }
}

```
从上面的代码可以看出，相比Java，省去了findviewbyid的操作，可根据xml的ID直接拿到控件进行操作，而且，kotlin支持lambda表达，所以点击事件也变得特别简洁。
</br>
<h4> 2. 无须再写getter和setter</h4>

在实现列表加载数据的时候，用到最多的，就是通过实体类，set数据给实体类，然后在Adapter中，通过实体类get得到数据，加载到控件中，如果需要实现id跟title的实体类，Java中的写法如下：

```
public class DataEntity {

    private String id;
    private String title;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
```

那么换成kotlin的话，只需一句话即可实现同样的功能：

```
data class DataEntity(val id: String, val title: String)
```
<h4> 3. 其他</h4>
  kotlin很多语法，相比Java都较为简洁，比如说在kotlin用when代替switch，而且能实现更多功能：
  

```
       val result: Any = 78
        
        when (result) {
            100 -> println("等于100")
            78, 80, 90 -> println("等于78或80或90")
            "我是谁" -> println("我是谁")
            in 60..99 -> println("在60-99区间内")
            is Int -> println("该字段是Int类型")
            else -> println("该字段不是Int类型")
        }
```
不仅仅可以判断类型，还可以判断数字的准确值、判断字符串、判断是否在区间内、判断几个或关系的条件。
</br>
再比如列表，kotlin为列表提供了很多方法，（关于List需要注意的是，在Java中，List是有add、addAll这些方法的，但是在kotlin中的List是没有这些方法的，但是可以用MutableList代替）

```
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

```
</br>
<h2>T-MVP在kotlin中的应用</h2>
mvp模式在Android中是被广泛接受，但是mvp的缺点之一就是类特别多，解决这个问题，有个很好的办法，就是用泛型。因为我在小公司，做的都是一些比较小的项目，没有涉及到太多的业务逻辑，所以，我这里直接省去了M层，只剩下v跟p；

 第一步，创建一个接口，实现一些基础方法，然后让BaseActivity继承这个view实现这些方法，一般是一些通用的方法，例如加载对话框、隐藏对话框等，然后让所有的Activity继承BaseActivity

```
interface BaseView {

    // 显示加载对话框
    fun showLoading()
    // 隐藏加载对话框
    fun hideLoading()
    // 显示空数据布局
    fun showNullLayout()
    // 隐藏空数据布局
    fun hideNullLayout()
    // 显示请求失败布局
    fun showErroLayout()
    // 隐藏请求失败布局
    fun hideErroLayout()
    // 请求失败后，将得到的结果通过接口，从P层传到V层
    fun getFailed(type: Any, T: Any)
}
```
 第二步，创建一个接口，继承BaseView，然后再实现多两个接口，供v层调用

```
interface UniversalView : BaseView {

    // view层设置数据，Presenter层通过接口得到数据，用于网络请求等参数的动态改变
    fun getData(): Any
    // 请求成功后，将得到的结果通过接口，从P层传到V层
    fun getSuccess(type: Any, T: Any)

}
```
第三步，封装基础的网络请求，我用的是[OkGo](https://github.com/jeasonlzy/okhttp-OkGo)，网络请求分为get请求跟post请求，代码分别如下:
<h2>GET</h2>
```
open class BaseOkgoGet : SingletonUtil<BaseOkgoGet>() {

    override fun newInstance(): BaseOkgoGet {
        return getInstance() as BaseOkgoGet
    }

    companion object {
        /**
         *@param type 用于一个Activity有多个网络请求的时候，在Presenter中区分回调类型
         *
         * @param url 请求网址
         *
         * */
        fun getData(context: Context, type: Int, url: String, universal: UniversalView, successListener: SuccessListener) {
            OkGo.get(url)
                    .execute(object : StringCallback() {
                        override fun onBefore(request: BaseRequest<*>?) {
                            universal.showLoading()
                        }

                        override fun onSuccess(s: String, call: Call, response: Response) {
                            ToastUtil.printData(s)
                            universal.hideErroLayout()
                            successListener.onSuccess(context, type, s)
                        }


                        override fun onError(call: Call?, response: Response?, e: Exception?) {
                            universal.showErroLayout()
                        }

                        override fun onAfter(s: String?, e: Exception?) {
                            universal.hideLoading()
                        }
                    })
        }
    }
}

```
<h2>POST</h2>
```
class BaseOkgoPost : SingletonUtil<BaseOkgoPost>() {

    override fun newInstance(): com.zerom.management.base.okgo.BaseOkgoPost {
        return getInstance()!!
    }

    companion object {

        /**
         * @param type 用于一个Activity有多个网络请求的时候，在Presenter中区分回调类型
         *
         * @param map post 的参数
         *
         * @param url 请求网址
         *
         * */

        fun getData(context: Context, type: Int, url: String, map: HashMap<String, String>, universalView: UniversalView, successListener: SuccessListener) {
            com.lzy.okgo.OkGo.post(url)
                    .params(map)
                    .execute(object : com.lzy.okgo.callback.StringCallback() {
                        override fun onBefore(request: com.lzy.okgo.request.BaseRequest<out BaseRequest<*>>?) {
                            super.onBefore(request)
                            universalView.showLoading()
                        }

                        override fun onSuccess(result: String?, p1: okhttp3.Call?, p2: okhttp3.Response?) {
                            universalView.hideErroLayout()
                            successListener.onSuccess(context, type, result!!)
                            ToastUtil.printData(result)
                        }

                        override fun onAfter(t: String?, e: java.lang.Exception?) {
                            super.onAfter(t, e)
                            universalView.hideLoading()
                        }

                        override fun onError(call: okhttp3.Call?, response: okhttp3.Response?, e: java.lang.Exception?) {
                            super.onError(call, response, e)
                            universalView.showErroLayout()
                        }

                    })
        }
    }

}
```
请求网络数据，得到的结果，通过SuccessListener接口抛出；

```
interface SuccessListener {
    fun onSuccess(context: Context, type: Any, results: String)
}

```
然后，如果在一个Presenter中，有多个网络请求，可以用以下的写法来实现Presenter

```
class MainPresenter(val context: Context, val view: UniversalView) : SuccessListener {

    companion object {
        val GET_SUCCESS_01 = 1
        val GET_SUCCESS_02 = 2
    }

    val entity: DataEntity = view.getData() as DataEntity

    fun getData_1() {
        BaseOkgoGet.getData(context, GET_SUCCESS_01, "url${entity.title}", view, this)
    }

    fun getData_2() {
        val map = hashMapOf("id" to entity.id, "title" to entity.title)
        BaseOkgoPost.getData(context, GET_SUCCESS_02, "url", map, view, this)
    }


    override fun onSuccess(context: Context, type: Any, results: String) {
        when (type) {
            GET_SUCCESS_01 -> {
                view.getSuccess(GET_SUCCESS_01, "我是第一个请求")
            }
            GET_SUCCESS_02 -> {
                view.getSuccess(GET_SUCCESS_02, "我是第二个请求")
            }
        }
    }
}
```
然后在Activity中，设置参数，发起请求，得到数据之后，加载到视图中

```
class MainActivity : BaseActivity(), UniversalView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTitle.setOnClickListener { toast("点击了标题") }
        //实现网络请求
        val presenter: MainPresenter = MainPresenter(this, this)
        presenter.getData_1()
        presenter.getData_2()
    }

    // 将数据传给p层
    override fun getData(): Any {
        val entity = DataEntity()
        entity.title = "我是标题"
        entity.id = "我是ID"
        return entity
    }

    override fun getSuccess(type: Any, T: Any) {
        when (type) {
        // 第一个网络请求成功
            MainPresenter.GET_SUCCESS_01 -> {
                val info = T as String
                toast(info)
            }
        //第二个请求成功
            MainPresenter.GET_SUCCESS_02 -> {
                val info = T as String
                toast(info)
            }
        }
    }
}

```
MVP的一大特性就是可重复调用，比如说，写一个获取用户信息的Presenter，有十个界面需要获取用户信息，那么都只要调用这一个Presenter就足够了；
</br>
<h2>kotlin的最强库anko的详细使用</h2>

学kotlin的人，基本都知道anko，它的强大已经不是一两句话就能说得清楚的了。具体可以通过[anko插件库](https://github.com/Kotlin/anko)以及[anko wiki](https://github.com/Kotlin/anko/wiki/Anko-Layouts#xml-to-dsl-converter)学习。
</br>
用kotlin之前，要先添加依赖

```
    compile "org.jetbrains.anko:anko:$anko_version"
    compile "org.jetbrains.anko:anko-support-v4:$anko_version"
    //版本号
    ext.anko_version = '0.10.1'
```
anko提供很多简化的方法，例如

```
        toast("")
        // 跳转Activity
        startActivity<MainActivity>()
        //跳转Activity带参数
        startActivity<MainActivity>("TAG" to "title")
        // startActivityForResult
        startActivityForResult<MainActivity>(1,"TAG" to "title","name" to "Hebin")
        // 带启动模式的startActivity
        startActivity(intentFor<MainActivity>("TAG" to "title").singleTop())
```
anko除了提供大量简化的方法之外，还提供了一种DSL布局，用来代替xml；DSL布局看上去很清晰，书写、熟悉难度也不大，最大的一个缺点，估计就是，没得预览；虽然官方有提供Anko Preview，但是，在高版本的Android Studio中，无法使用。。
</br>
DSL布局可以直接写在Activity中，但是，我不喜欢把所有代码都堆在一块，所以，我是新建了个Mainview.kt，布局内添加一个按钮，代码如下：

```
class Mainview : AnkoComponent<Activity> {

    companion object {
        val BTN_ID = 1
    }

    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        // verticalLayout相当于垂直方向的LinearLayout
        verticalLayout {

            gravity = Gravity.CENTER
            // dip 是将dp转换为px，px2dip是将px转换为dp，px2sp是将px转换为sp
            padding = dip(10)
            backgroundColor = Color.GRAY

            lparams {
                width = matchParent
                height = matchParent
            }

            button("登录") {
                id = BTN_ID
                textSize = 16f
                textColor = Color.WHITE
                onClick { toast("点击了按钮") }
                backgroundColor = resources.getColor(R.color.colorPrimary)
            }.lparams {
                width = matchParent
                height = dip(50)
            }
        }
    }
}
```
然后在Activity的oncreat中，setContentView即可；

```
 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mainview().setContentView(this)
        }
```
<h3>效果图如下：<h3>

![这里写图片描述](http://img.blog.csdn.net/20170728095826501?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvSGViaW4zMjAzMjA=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
</br>
成功加载布局之后，那么接下来就是怎么对布局中的控件进行操作，从上面布局的代码中可以看出，按钮button有个ID。所以，在Activity中就可以通过ID来操控控件，具体代码如下：

```
 find<Button>(Mainview.BTN_ID).text = "我成功改变了按钮文字"
```
这种方法虽然可以操作控件，但是，当你在实践的过程你会发现，ID只能是数字，当一个布局嵌套了多个布局的时候，ID的赋值会变得很头大，所以我就换了种方式实现，修改了一下view的代码：

```
@SuppressLint("StaticFieldLeak")
class Mainview : AnkoComponent<Activity> {

    companion object {
        var btnLoad: Button? = null
    }

    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        // verticalLayout相当于垂直方向的LinearLayout
        verticalLayout {

            gravity = Gravity.CENTER
            // dip 是将dp转换为px，px2dip是将px转换为dp，px2sp是将px转换为sp
            padding = dip(10)
            backgroundColor = Color.GRAY

            lparams {
                width = matchParent
                height = matchParent
            }

            btnLoad = button("登录") {
                textSize = 16f
                textColor = Color.WHITE
                onClick { toast("点击了按钮") }
                backgroundColor = resources.getColor(R.color.colorPrimary)
            }.lparams {
                width = matchParent
                height = dip(50)
            }
        }
    }
}
```
创建了一个Button，并且将这个布局用到创建布局中，然后在Activity中操作控件：

```
Mainview.btnLoad?.text  = "我成功改变了按钮文字"
```
然后，你可能又会想到一个问题，很多界面都会有标题栏，如果我想把标题栏写成一个布局，然后让需要用到标题栏的布局，直接包含它就可以，就跟xml的include一样。其实DSL也是支持include布局中的xml文件的；

```
 include<LinearLayout>(R.layout.activity_main)
```
但是，既然都用DSL布局了，那就全都用DSL吧，首先，创建一个SimpleTitle.kt文件，可以通过以下代码实现布局的可调用性；

```
@Suppress("NOTHING_TO_INLINE")
inline fun ViewManager.simpleTitle() = simpleTitle({})

inline fun ViewManager.simpleTitle(init: SimpleTitle.() -> Unit, theme: Int = 0) = ankoView(::SimpleTitle, theme, init)
```
标题栏布局中有个返回按钮跟一个居中的标题，具体代码如下；

```
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
                    height = matchParent
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
```

然后在Mainview的布局中添加多一句` simpleTitle()`，即可将标题栏给包含进来，同样，在Activity中，可以直接拿到标题栏布局中的控件进行操作；

```
     SimpleTitle.ivBack?.setOnClickListener({ finish() })
     SimpleTitle.tvTitle?.text = "我是标题"
```
kotlin可以学习的东西还有很多，将来如果有什么学习体会，会继续补充进来;如果有哪儿说得不好，或者有更好的学习的东西，欢迎回复或者私信我。
