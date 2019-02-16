package com.zxx.threepigeon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushClickedResult;
import com.tencent.android.tpush.XGPushRegisterResult;
import com.tencent.android.tpush.XGPushShowedResult;
import com.tencent.android.tpush.XGPushTextMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoxx on 2019/2/15.
 */

public class MessageReceiver extends XGPushBaseReceiver {

    private static List<PigeonMessageListener> list = new ArrayList<PigeonMessageListener>();

    public static void addPigeonMessageListener(PigeonMessageListener listener){
        list.add(listener);
    }

    public static void removePigeonMessageListener(PigeonMessageListener listener){
        for (PigeonMessageListener key : list){
            if(key == listener){
                list.remove(key);
                break;
            }
        }
    }

    @Override
    public void onRegisterResult(Context context, int i, XGPushRegisterResult xgPushRegisterResult) {

    }

    @Override
    public void onUnregisterResult(Context context, int i) {

    }

    @Override
    public void onSetTagResult(Context context, int i, String s) {

    }

    @Override
    public void onDeleteTagResult(Context context, int i, String s) {

    }

    @Override
    public void onTextMessage(Context context, XGPushTextMessage xgPushTextMessage) {
        String string = xgPushTextMessage.getContent();
        for (PigeonMessageListener listener: list){
            listener.callback(string);
        }
    }

    @Override
    public void onNotifactionClickedResult(Context context, XGPushClickedResult xgPushClickedResult) {

    }

    @Override
    public void onNotifactionShowedResult(Context context, XGPushShowedResult xgPushShowedResult) {
        String string = xgPushShowedResult.getContent();
        for (PigeonMessageListener listener: list){
            listener.callback(string);
        }
    }
}
