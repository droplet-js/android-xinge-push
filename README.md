# android-xinge-push

[![Build Status](https://cloud.drone.io/api/badges/v7lin/android-xinge-push/status.svg)](https://cloud.drone.io/v7lin/android-xinge-push)
[![GitHub tag](https://img.shields.io/github/tag/v7lin/android-xinge-push.svg)](https://github.com/v7lin/android-xinge-push/releases)
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)

### docs

* [信鸽推送-官方网站](http://xg.qq.com)
* [信鸽推送-快速指南](https://xg.qq.com/docs/)
* [华为推送](https://developer.huawei.com/consumer/cn/service/hms/pushservice.html)
* [小米推送](https://dev.mi.com/console/appservice/push.html)
* [魅族推送](https://open.flyme.cn/open-web/views/push.html)

### snapshot

````
ext {
    latestVersion = '1.0.0-SNAPSHOT'
}

allprojects {
    repositories {
        ...
        maven {
            url 'https://oss.jfrog.org/artifactory/oss-snapshot-local'
        }
        ...
    }
}
````

### release

````
ext {
    latestVersion = '1.0.0'
}

allprojects {
    repositories {
        ...
        jcenter()
        ...
    }
}
````

### usage

* android

````
...
android {
    ...
    defaultConfig {
        ...
        manifestPlaceholders = [
                XG_ACCESS_ID: "信鸽ACCESSID",
                XG_ACCESS_KEY: "信鸽ACCESSKEY",
                HW_APPID: "华为的APPID",
                XIAOMI_APPID: "小米的APPID",
                XIAOMI_APPKEY: "小米的APPKEY",
                MEIZU_APPID: "魅族的APPID",
                MEIZU_APPKEY: "魅族的APPKEY"
        ]
        ...
    }
    ...
}
...
dependencies {
    ...
    implementation "io.github.v7lin:xinge-push-android:${latestVersion}"
    implementation "io.github.v7lin:xinge-push-stub-android:${latestVersion}"
    ...
}
...
````

### example

[android example](./app/src/main/java/io/github/v7lin/xingepush/MainActivity.java)
