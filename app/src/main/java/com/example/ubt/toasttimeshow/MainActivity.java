package com.example.ubt.toasttimeshow;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import static com.example.ubt.toasttimeshow.MyToast.showToast;
import static com.example.ubt.toasttimeshow.MyToast.showToast2;


public class MainActivity extends ActionBarActivity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        TextView mText = (TextView) findViewById(R.id.myTextView);
        mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(mContext, "kkkkkkkkkkkkkkk", 500);
            }
        });

        TextView mText2 = (TextView) findViewById(R.id.myTextView2);
        mText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast2(mContext, "mmmm", 500);
            }
        });


        TextView mText3 = (TextView) findViewById(R.id.myTextView3);
        mText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                CustomToast toast = new CustomToast(mContext, "333333", 3000);
//                toast.show();
                CustomToast.makeText(mContext, "kfeja", 2000).show();
            }
        });

    }


}
