package com.example.administrator.newsapp.Menupage;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.newsapp.MainActivity;
import com.example.administrator.newsapp.R;
import com.example.administrator.newsapp.bean.Categories;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.viewpagerindicator.TabPageIndicator;

/**
 * Created by Administrator on 16-4-13.
 */
public class hotnewsmenupage extends menupage
{
    private Categories.NewsTypeInfo menupageInfo;
    private ViewPager hotnewsmenupageContent;
    private TabPageIndicator hotnewsmenupageTitle;
    Activity AActivity;
    public hotnewsmenupage(Activity Activity, Categories.NewsTypeInfo menuinfo)
    {
        super(Activity);
        menupageInfo=menuinfo;
        this.AActivity=Activity;
    }

    public View initView()
    {
        View view = View.inflate(AActivity, R.layout.hot_news_menu_page, null);
        hotnewsmenupageContent = (ViewPager) view.findViewById(R.id.hotnewmenupage_content);
        hotnewsmenupageTitle = (TabPageIndicator) view.findViewById(R.id.hotnewsmenupage_title);
        return view;
    }

    public void initData()
    {
        hotnewsmenupageContent.setAdapter(new MyhotnewsmenupageViewPager());
        hotnewsmenupageTitle.setViewPager(hotnewsmenupageContent);
        hotnewsmenupageTitle.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
                MainActivity mActivity = (MainActivity) hotnewsmenupage.this.AActivity;
                if (position==0)
                {
                    mActivity.getMySlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                }
                else
                {
                    mActivity.getMySlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                }
            }

            @Override
            public void onPageSelected(int position)
            {

            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
    }

    class MyhotnewsmenupageViewPager extends PagerAdapter
    {
        @Override
        public CharSequence getPageTitle(int position)
        {
            return  menupageInfo.children.get(position).title;
        }

        @Override
        public int getCount()
        {
            return menupageInfo.children.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            hotnewsmenupagedetail detail = new hotnewsmenupagedetail(AActivity,menupageInfo.children.get(position));
            container.addView(detail.mRootView);
            return detail.mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            container.removeView((View) object);
        }
    }
}
