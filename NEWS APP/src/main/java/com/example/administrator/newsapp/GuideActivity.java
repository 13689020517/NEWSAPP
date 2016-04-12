package com.example.administrator.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity
{
    private List<ImageView> viewlist;
    private int[] pic;
    private LinearLayout ll;
    private Button bt;
    private FrameLayout fl;
    private View reddotview;
    private FrameLayout.LayoutParams fLparams;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        getSupportActionBar().hide();
        viewlist = new ArrayList<ImageView>();
        bt = (Button) findViewById(R.id.Bt);
        ll = (LinearLayout) findViewById(R.id.LL);
        fl = (FrameLayout) findViewById(R.id.FL);
        reddot();
        pic = new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
        //加载要用的数据列表
        initdatalist();
        final ViewPager viewpager= (ViewPager) findViewById(R.id.ViewPager);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
                 fLparams.leftMargin=position*60+(int)(positionOffset*60);
                 reddotview.setLayoutParams(fLparams);

            }

            @Override
            public void onPageSelected(int position)
            {
                if(position==(viewlist.size()-1))
                {
                    bt.setVisibility(View.VISIBLE);
                }
                else
                {
                    bt.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state)
                {

            }
        });
        //对ViewPager进行填充
        viewpager.setAdapter(new PagerAdapter()
        {
            @Override
            public int getCount()
            {
                return 3;
            }

            @Override
            public boolean isViewFromObject(View view, Object object)
            {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position)
            {
                ImageView iv=viewlist.get(position);
                container.addView(iv);
                return iv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {
                ImageView iv=viewlist.get(position);
                viewpager.removeView(iv);
            }
        });
    }
            public void initdatalist()
            {
                for(int i=0;i<3;i++)
                {
                    ImageView IV=new ImageView(this);
                    IV.setImageResource(pic[i]);
                    viewlist.add(IV);
                    Log.i("TAG","ViewPager所用数据加载完毕");
                    View view=new View(this);
                    view.setBackgroundResource(R.drawable.guide_grey_dot);
                    LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(40,40);
                    if(i==0)
                    {

                    }
                    else
                    {
                        params.leftMargin=20;
                    }
                    view.setLayoutParams(params);
                    ll.addView(view);
                    Log.i("TAG","guidedot所用数据加载完毕");
                }
            }
            public void click(View view)
            {
                startActivity(new Intent(this,MainActivity.class));
                finish();
            }
            public void reddot()
            {
                reddotview = new View(this);
                reddotview.setBackgroundResource(R.drawable.guide_red_dot);
                fLparams = new FrameLayout.LayoutParams(40,40);
                reddotview.setLayoutParams(fLparams);
                fl.addView(reddotview);
            }
}
