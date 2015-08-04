package com.example.ubt.toasttimeshow;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 自定义Toast提示
 * Created by GuoJ on 15-7-30.
 */
public class MyToast {
    static Toast toast = null;
    static Handler handler = new Handler();
    static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            toast.cancel();
        }
    };

    /**
     * 可自定义显示时间，重复显示的Toast
     * @param mContext
     * @param word        显示内容
     * @param time        显示时间 ms
     */
    public static void showToast(final Context mContext, final String word, final long time) {

        handler.removeCallbacks(runnable);

        if (toast != null) {
            toast.setText(word);
        } else {
            toast = new Toast(mContext);
            toast = Toast.makeText(mContext, word, Toast.LENGTH_LONG);
        }

        handler.postDelayed(runnable, time);
        toast.show();
    }



    /**
     * 可自定义布局，重复显示的Toast
     * @param mContext
     * @param word        显示内容
     * @param time        显示时间 ms
     */
    public static void showToast2(final Context mContext, final String word, final long time) {

        handler.removeCallbacks(runnable);

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        View view = inflater.inflate(R.layout.toast_layout, null);
        TextView msgText = (TextView) view.findViewById(R.id.toast_text);
        msgText.setText(word);

        if (toast == null) {
            toast = new Toast(mContext);
        }

        handler.postDelayed(runnable, time);

        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(view);
        toast.show();
    }
}
