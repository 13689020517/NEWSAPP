package com.example.administrator.newsapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.administrator.newsapp.Page.govermentpage;
import com.example.administrator.newsapp.Page.homepage;
import com.example.administrator.newsapp.Page.newspage;
import com.example.administrator.newsapp.Page.page;
import com.example.administrator.newsapp.Page.settingpage;
import com.example.administrator.newsapp.Page.smartservicepage;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-4-12.
 */
public class content_fragment extends Fragment
{
    private View v1;
    private List<page> list;
    private ViewPager vp;
    private RadioGroup rg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        v1 = inflater.inflate(R.layout.content_fragment,null);
        list = new ArrayList<page>();
        vp = (ViewPager) v1.findViewById(R.id.viewpager);
        rg = (RadioGroup) v1.findViewById(R.id.rg_contentfragment_bottom);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.rb_contentfragment_home:
                        ((MainActivity)getActivity()).getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                        vp.setCurrentItem(0,false);
                        break;
                    case R.id.rb_contentfragment_newscenter:
                        ((MainActivity)getActivity()).getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                        vp.setCurrentItem(1,false);
                        break;
                    case R.id.rb_contentfragment_service:
                        ((MainActivity)getActivity()).getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                        vp.setCurrentItem(2,false);
                        break;
                    case R.id.rb_contentfragment_gov:
                        ((MainActivity)getActivity()).getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                        vp.setCurrentItem(3,false);
                        break;
                    case R.id.rb_contentfragment_setting:
                        ((MainActivity)getActivity()).getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                        vp.setCurrentItem(4,false);
                        break;
                }
            }
        });
        list.add(new homepage(getActivity(),(MainActivity) getActivity()));
        list.add(new newspage(getActivity(),(MainActivity) getActivity()));
        list.add(new smartservicepage(getActivity(),(MainActivity) getActivity()));
        list.add(new govermentpage(getActivity(),(MainActivity) getActivity()));
        list.add(new settingpage(getActivity(),(MainActivity) getActivity()));
        vp.setAdapter(new PagerAdapter()
        {
            @Override
            public int getCount()
            {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object)
            {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position)
            {
                container.addView(list.get(position).getmRootView());
                return list.get(position).getmRootView();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {
                container.removeView(list.get(position).getmRootView());
            }
        });
        return v1;
    }

       public newspage getnewspage()
       {
           if (list!=null)
               return (newspage) list.get(1);
           return  null;
       }
}
