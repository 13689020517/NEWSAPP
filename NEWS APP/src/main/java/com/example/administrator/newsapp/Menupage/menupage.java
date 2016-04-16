package com.example.administrator.newsapp.Menupage;

import android.app.Activity;
import android.view.View;

/**
 * Created by Administrator on 16-4-13.
 */
public abstract class menupage
{
    protected Activity mActivity;
    public View mRootView;
    public menupage(Activity mActivity)
    {
        this.mActivity = mActivity;
    }

    public void initmRootView()
    {
        mRootView=initView();
    }

    public abstract View initView() ;
    public abstract  void initData() ;
}
