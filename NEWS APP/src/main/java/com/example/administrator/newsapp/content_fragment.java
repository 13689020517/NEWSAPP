package com.example.administrator.newsapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-4-12.
 */
public class content_fragment extends Fragment
{
    private List<TextView> list;
    private ViewPager vp;
    private View v1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        v1 = inflater.inflate(R.layout.content_fragment,null);
        list = new ArrayList<TextView>();
        vp = (ViewPager) v1.findViewById(R.id.viewpager);
        for(int i=0;i<5;i++)
        {
            TextView tv=new TextView(getActivity());
            tv.setText("首页");
            list.add(tv);
        }
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
                container.addView(list.get(position));
                return list.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {
                container.removeView(list.get(position));
            }
        });
        return v1;
    }
}
