package com.example.administrator.newsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

public class SplashActivity extends AppCompatActivity
{

    private RelativeLayout rllayout;
    private AnimationSet as;
    private RotateAnimation ra;
    private AlphaAnimation aa;
    private ScaleAnimation sa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        //设置动画效果
        initanimation();
        //设置动画监听事件
        Log.i("监听动画前","监听动画前");
        as.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            //当动画结束的时候，选择跳转，如果是第一次进入则跳转到guide界面；如果不是第一次进入则跳转到主界面
            public void onAnimationEnd(Animation animation)
            {
                Log.i("监听动画前","监听动画后");
                SharedPreferences SP=((Myapplication)SplashActivity.this.getApplication()).getSP();
                boolean isfirst=SP.getBoolean("isfirst",true);
                if(isfirst)
                {
                    SP.edit().putBoolean("isfirst",false);
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                    finish();
                }
                else
                {
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });
}

    public void initanimation()
    {
        as = new AnimationSet(false);
        ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(2000);
        ra.setFillAfter(true);
        as.addAnimation(ra);
        aa = new AlphaAnimation(0, 1);
        aa.setDuration(2000);
        aa.setFillAfter(true);
        as.addAnimation(aa);
        sa = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(2000);
        sa.setFillAfter(true);
        as.addAnimation(sa);
        rllayout = (RelativeLayout) findViewById(R.id.RLayout);
        rllayout.startAnimation(as);
    }
}
