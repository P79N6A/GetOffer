package com.up.lhm.getoffer.touchevent;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings.System;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.LruCache;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.up.lhm.getoffer.R;
import com.up.lhm.hmtools.system.IntentUtil;
import com.up.lhm.hmtools.system.Log;

import java.util.List;

/**
 * @author lianghaimiao
 * @date 2019/3/1
 * @function
 */

public class EventDispatchActivity extends AppCompatActivity {

    private Button mBtn;
    private RelativeLayout mRl;
    private Customview mView;
    private CustomViewGroup mViewGroup;
    private Cd mCd;


    public static void start(Context context, boolean finishSelf) {

        Intent intent = new Intent();
        intent.setAction("android.intent.action.Atext");
        PackageManager packageManager = context.getPackageManager();
        ResolveInfo resolveInfo = packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        context.startActivity(intent);
//        Bundle args = new Bundle();
//        IntentUtil.redirect(context, EventDispatchActivity.class, finishSelf, args);
    }

    @Override
    protected void onCreate(@Nullable   Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);
        mRl = findViewById(R.id.rl);
        mBtn = findViewById(R.id.btn);

        mViewGroup = findViewById(R.id.cg);
        mView = findViewById(R.id.cv);

        mCd = findViewById(R.id.cd);

        mCd.setOntouListener(new OntouListener() {
            @Override
            public void setclick(String string) {
                Log.d("cuevent","响应了事件"+string);
            }
        });
    }

    /**
     * 1.dispatchTouchEvent返回的是onTouchEvent是否消费的结果
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("事件分发", "activity---》dispatchTouchEvent事件分发: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("事件分发", "activity---》dispatchTouchEvent事件分发: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("事件分发", "activity---》dispatchTouchEvent事件分发: ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("事件分发", "activity---》onTouchEvent事件分发: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("事件分发", "activity---》onTouchEvent事件分发: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("事件分发", "activity---》onTouchEvent事件分发: ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }


    private void viewGroupTouch() {

    }

    private void viewTouch() {
        mBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        mBtn.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("事件分发", "mBtnview事件分发: ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d("事件分发", "mBtnview事件分发: ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("事件分发", "mBtnview事件分发: ACTION_UP");
                        break;
                }
                return true;
            }
        });

        mView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("事件分发", "view事件分发: ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d("事件分发", "view事件分发: ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("事件分发", "view事件分发: ACTION_UP");
                        break;
                }

                return true;
            }
        });
        mView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("事件分发", "点击了按钮");
            }
        });
    }
}
