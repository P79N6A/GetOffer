package com.up.lhm.getoffer;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.up.lhm.hmtools.system.IntentUtil;

/**
 * @author lianghaimiao
 * @date 2019/3/31
 * @function
 */

public class AntimatorsActivity extends Activity {

    private TextView mTextView;

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, AntimatorsActivity.class, finishSelf, args);
    }
    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animator_layout);
        mTextView = findViewById(R.id.tv);
        Animation a = new AlphaAnimation(0,100);
        Animation b = new ScaleAnimation(1,100,3,11);
        Animation c = new RotateAnimation(0,100);
        Animation d = new TranslateAnimation(1,2,3,33);
        mTextView.startAnimation(a);
        ObjectAnimator.ofFloat(mTextView, "rotationX", 0.0F, 360.0F)
                .setDuration(500)
                .start();
    }
}
