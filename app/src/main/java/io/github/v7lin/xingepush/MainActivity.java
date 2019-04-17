package io.github.v7lin.xingepush;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 开启debug日志数据
        XGPushConfig.enableDebug(this, true);
        // 开启厂商通道初始化代码
        try {
            ApplicationInfo appInfo = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            Log.d("TPush", "huawei appid: " + appInfo.metaData.get("com.huawei.hms.client.appid"));
            Log.d("TPush", "xiaomi appid: " + appInfo.metaData.get("com.xiaomi.mipush.sdk.appid"));
            Log.d("TPush", "xiaomi appkey: " + appInfo.metaData.get("com.xiaomi.mipush.sdk.appkey"));
            Log.d("TPush", "meizu appid: " + appInfo.metaData.get("com.meizu.cloud.pushsdk.appid"));
            Log.d("TPush", "meizu appkey: " + appInfo.metaData.get("com.meizu.cloud.pushsdk.appkey"));
//            XGPushConfig.enableOtherPush(getApplicationContext(), true);
//            XGPushConfig.setHuaweiDebug(true);
//            XGPushConfig.setMiPushAppId(getApplicationContext(), appInfo.metaData.getString("com.xiaomi.mipush.sdk.appid"));
//            XGPushConfig.setMiPushAppKey(getApplicationContext(), appInfo.metaData.getString("com.xiaomi.mipush.sdk.appkey"));
//            XGPushConfig.setMzPushAppId(getApplicationContext(), appInfo.metaData.getString("com.meizu.cloud.pushsdk.appid"));
//            XGPushConfig.setMzPushAppKey(getApplicationContext(), appInfo.metaData.getString("com.meizu.cloud.pushsdk.appkey"));
        } catch (PackageManager.NameNotFoundException ignore) {
        }
        // token注册
        XGPushManager.registerPush(getApplicationContext(), new XGIOperateCallback() {
            @Override
            public void onSuccess(Object data, int flag) {
                //token在设备卸载重装的时候有可能会变
                Log.d("TPush", "注册成功，设备token为：" + data);
            }

            @Override
            public void onFail(Object data, int errCode, String msg) {
                Log.d("TPush", "注册失败，错误码：" + errCode + ",错误信息：" + msg);
            }
        });
    }
}
