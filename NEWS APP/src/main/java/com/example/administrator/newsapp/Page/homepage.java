package com.example.administrator.newsapp.Page;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.newsapp.MainActivity;
import com.example.administrator.newsapp.R;

/**
 * Created by Administrator on 16-4-13.
 */
public class homepage extends page
{
    private View rootv;
    private TextView tv;

    public homepage(Context context, MainActivity MActivity)
    {
        super(MActivity);
        initview(context);
    }
    public void initview(Context context)
    {
        rootv = View.inflate(context, R.layout.page,null);
        tv = (TextView) rootv.findViewById(R.id.tv);
        tv.setText("首页");
        initdata();
    }
    public void initdata()
    {
    }
    public View getrootv()
    {
        return rootv;
    }
}