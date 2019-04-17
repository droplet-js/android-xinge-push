package io.github.v7lin.xingepush;

import android.app.Activity;
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
        XGPushConfig.enableDebug(this,true);
        // 开启厂商通道初始化代码
        XGPushConfig.enableOtherPush(getApplicationContext(), true);
        XGPushConfig.setHuaweiDebug(true);
        XGPushConfig.setMiPushAppId(getApplicationContext(), "APPID");
        XGPushConfig.setMiPushAppKey(getApplicationContext(), "APPKEY");
        XGPushConfig.setMzPushAppId(this, "APPID");
        XGPushConfig.setMzPushAppKey(this, "APPKEY");
        // token注册
        XGPushManager.registerPush(this, new XGIOperateCallback() {
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
