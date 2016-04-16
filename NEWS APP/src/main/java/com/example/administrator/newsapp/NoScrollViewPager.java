package com.example.administrator.newsapp;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 16-4-13.
 */
public class NoScrollViewPager extends ViewPager
{
    public NoScrollViewPager(Context context)
    {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {
        return false;
    }
}
