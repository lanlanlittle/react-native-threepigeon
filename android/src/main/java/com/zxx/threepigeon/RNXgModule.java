
package com.zxx.threepigeon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushClickedResult;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.XGPushRegisterResult;
import com.tencent.android.tpush.XGPushShowedResult;
import com.tencent.android.tpush.XGPushTextMessage;
import com.tencent.android.tpush.common.Constants;

public class RNXgModule extends ReactContextBaseJavaModule implements PigeonMessageListener{

  private final ReactApplicationContext reactContext;
  private Message m;

  public RNXgModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;

    //开启信鸽的日志输出，线上版本不建议调用
    XGPushConfig.enableDebug(reactContext, true);
    XGPushConfig.getToken(reactContext);

    /*
        注册信鸽服务的接口
        如果仅仅需要发推送消息调用这段代码即可
        */
    XGPushManager.registerPush(reactContext,
            new XGIOperateCallback() {
              @Override
              public void onSuccess(Object data, int flag) {
                Log.w(Constants.LogTag, "+++ register push sucess. token:" + data + "flag" + flag);
              }

              @Override
              public void onFail(Object data, int errCode, String msg) {
                Log.w(Constants.LogTag,
                        "+++ register push fail. token:" + data
                                + ", errCode:" + errCode + ",msg:"
                                + msg);
              }
            });

    // 获取token
//    XGPushConfig.getToken(reactContext);
  }

    @Override
    public void initialize() {
        super.initialize();
        MessageReceiver.addPigeonMessageListener(this);
    }

    @Override
    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        MessageReceiver.removePigeonMessageListener(this);
    }

  @Override
  public String getName() {
    return "RNXg";
  }

    @Override
    public void callback(String string) {
        WritableMap map = Arguments.createMap();
        map.putString("message", string);
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("onMsgReceiver", map);
    }
}