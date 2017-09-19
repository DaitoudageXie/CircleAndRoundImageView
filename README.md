# CircleAndRoundImageView
## 1.简单介绍
这是一个圆形图片和圆角图片库
* 圆形图片取自[hdodenhof/CircleImageView](https://github.com/hdodenhof/CircleImageView),完全搬过来
* 圆角图片根据[安卓自定义上面圆角下面直角的RoundCornerImageView](http://blog.csdn.net/qq787207389/article/details/51958057)的博文修改完成
## 2.基本用法
* 引入方法
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
```
dependencies {
	        compile 'com.github.DaitoudageXie:CircleAndRoundImageView:v1.0.0'
	}
```
* CircleImageView就忽略了，原项目写的很清楚
* RoundImageView
全部都是一样的圆角
```
<com.bowangzx.imageviewlibrary.RoundImageView
        android:id="@+id/riv"
        android:layout_width="300dp"
        android:layout_height="300dp"
        android:src="@mipmap/a"
        app:riv_radius="10dp"/>

```
不全部为圆角
```
<com.bowangzx.imageviewlibrary.RoundImageView
        android:id="@+id/riv"
        android:layout_width="300dp"
        android:layout_height="300dp"
        android:src="@mipmap/a"
        app:riv_radius_bottom_left="10dp"
        app:riv_radius_bottom_right="10dp"
        app:riv_radius_top_left="10dp"
        app:riv_radius_top_right="10dp" />
```
