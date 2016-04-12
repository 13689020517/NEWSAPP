package com.example.administrator.newsapp;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 16-4-9.
 */
public class Myapplication extends Application
{
        public SharedPreferences SP;
    @Override
    public void onCreate()
    {
        super.onCreate();
        SP=getSharedPreferences("MySP",MODE_PRIVATE);
    }

    public SharedPreferences getSP()
        {
            return SP;
        }
}
