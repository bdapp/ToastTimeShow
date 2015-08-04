package com.example.ubt.toasttimeshow;

/**
 * Created by GuoJ on 15-8-3.
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class CustomToast {
    private static final int MESSAGE_TIMEOUT = 2;
    private WindowManager wdm;
    private double time;
    private View mView;
    private WindowManager.LayoutParams params;
    private WorkerHandler mHandler;

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public CustomToast(Context context, String text, double time) {
        wdm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mHandler = new WorkerHandler();

        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        mView = toast.getView();

        params = new WindowManager.LayoutParams();
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.format = PixelFormat.TRANSLUCENT;
//        params.windowAnimations = toast.getView().getAnimation().INFINITE;
        params.windowAnimations = R.style.custom_toast_anim_view;
        params.type = WindowManager.LayoutParams.TYPE_TOAST;
        params.setTitle("Toast");
//        params.verticalWeight = 100;
//        params.verticalMargin = -200;
//        params.horizontalMargin = 10;
//        params.horizontalWeight = 10;
        params.gravity = Gravity.BOTTOM;

        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;

        this.time = time;
    }

    public static CustomToast makeText(Context context, String text, double time) {
        CustomToast toastCustom = new CustomToast(context, text, time);
        return toastCustom;
    }

    public void show() {
        wdm.addView(mView, params);
        mHandler.sendEmptyMessageDelayed(MESSAGE_TIMEOUT, (long) (time));
    }

    public void cancel() {
        wdm.removeView(mView);
    }

    private class WorkerHandler extends Handler {
        @Override
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case MESSAGE_TIMEOUT:
                    cancel();
                    break;
            }
        }
    }
}
