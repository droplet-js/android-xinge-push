package xinge.push.android;

import com.tencent.android.tpush.XGPushConfig;

public final class XinGeConstants {

    private XinGeConstants() {
    }

    // 信鸽
    public static final String META_KEY_XG_ACCESS_ID = XGPushConfig.TPUSH_ACCESS_ID;
    public static final String META_KEY_XG_ACCESS_KEY = XGPushConfig.TPUSH_ACCESS_KEY;

    // 华为
    public static final String META_KEY_HW_APPID = "com.huawei.hms.client.appid";

    // 小米
    public static final String META_KEY_XIAOMI_APPID = "com.xiaomi.mipush.sdk.appid";
    public static final String META_KEY_XIAOMI_APPKEY = "com.xiaomi.mipush.sdk.appkey";

    // 魅族
    public static final String META_KEY_MEIZU_APPID = "com.meizu.cloud.pushsdk.appid";
    public static final String META_KEY_MEIZU_APPKEY = "com.meizu.cloud.pushsdk.appkey";
}
