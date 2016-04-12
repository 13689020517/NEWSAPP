package com.example.administrator.newsapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;


public class MainActivity extends SlidingFragmentActivity
{
    private SlidingMenu slidingMenu;
    private left_fragment leftfragment;
    private content_fragment content;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.left_menu);
        slidingMenu = getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindOffset(340);
        leftfragment = new left_fragment();
        content = new content_fragment();
        FragmentManager fragmentmanager=getFragmentManager();
        FragmentTransaction FT= fragmentmanager.beginTransaction();
        FT.replace(R.id.main,content);
        FT.replace(R.id.left,leftfragment);
        FT.commit();
    }
}
