package io.github.v7lin.xingepush;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

import xinge.push.stub.android.XinGeConstants;

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
            Log.d("TPush", "xinge accessid: " + appInfo.metaData.get(XGPushConfig.TPUSH_ACCESS_ID));
            Log.d("TPush", "xinge accesskey: " + appInfo.metaData.getString(XGPushConfig.TPUSH_ACCESS_KEY));
            Log.d("TPush", "huawei appid: " + appInfo.metaData.get(XinGeConstants.META_KEY_HW_APPID));
            Log.d("TPush", "xiaomi appid: " + appInfo.metaData.getString(XinGeConstants.META_KEY_XIAOMI_APPID));
            Log.d("TPush", "xiaomi appkey: " + appInfo.metaData.getString(XinGeConstants.META_KEY_XIAOMI_APPKEY));
            Log.d("TPush", "meizu appid: " + appInfo.metaData.getString(XinGeConstants.META_KEY_MEIZU_APPID));
            Log.d("TPush", "meizu appkey: " + appInfo.metaData.getString(XinGeConstants.META_KEY_MEIZU_APPKEY));
            XGPushConfig.enableOtherPush(getApplicationContext(), true);
            XGPushConfig.setHuaweiDebug(true);
            XGPushConfig.setMiPushAppId(getApplicationContext(), appInfo.metaData.getString(XinGeConstants.META_KEY_XIAOMI_APPID));
            XGPushConfig.setMiPushAppKey(getApplicationContext(), appInfo.metaData.getString(XinGeConstants.META_KEY_XIAOMI_APPKEY));
            XGPushConfig.setMzPushAppId(getApplicationContext(), appInfo.metaData.getString(XinGeConstants.META_KEY_MEIZU_APPID));
            XGPushConfig.setMzPushAppKey(getApplicationContext(), appInfo.metaData.getString(XinGeConstants.META_KEY_MEIZU_APPKEY));
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
