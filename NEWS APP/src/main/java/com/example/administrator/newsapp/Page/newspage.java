package com.example.administrator.newsapp.Page;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.newsapp.MainActivity;
import com.example.administrator.newsapp.Menupage.hotnewsmenupage;
import com.example.administrator.newsapp.Menupage.interactnewsmenupage;
import com.example.administrator.newsapp.Menupage.menupage;
import com.example.administrator.newsapp.Menupage.picturenewsmenupage;
import com.example.administrator.newsapp.Menupage.topicnewsmenupage;
import com.example.administrator.newsapp.R;
import com.example.administrator.newsapp.bean.Categories;
import com.example.administrator.newsapp.bean.Constans;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;

public class newspage extends page
{
    private View rootv;
    private TextView tv;
    private MainActivity MA;
    List<menupage> typelist=new ArrayList<menupage>();
    public newspage(Context context, MainActivity MActivity)
    {
        super(MActivity);
        MA=MActivity;
        initview(context);
    }
    public void initview(Context context)
    {
        rootv  = View.inflate(context, R.layout.page,null);
        tv = (TextView) rootv.findViewById(R.id.tv);
        initdata();
    }
    public void initdata()
    {
        tv_page_title.setText("新闻");
        ll_page_content.removeAllViews();
        TextView tv= new TextView(mActivity);
        tv.setText("新闻内容" );
        tv.setGravity(Gravity.CENTER);
        ll_page_content.addView(tv);
        bt_page_left.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MA.setSlidingMenuToggle();
            }
        });

        //在这里去想服务器拿数据
        HttpUtils http = new HttpUtils();
        http.send(HttpRequest.HttpMethod.GET, Constans.SERVER_ADDR+"/categories.json", new RequestCallBack<String>()
        {
            private Categories categories;
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo)
            {
                String result = responseInfo.result;
                Gson gson = new Gson();
                categories = gson.fromJson(result, Categories.class);
                MA.getLeftfragment().setCategories(categories);
                typelist.add( new hotnewsmenupage(mActivity,categories.data.get(0)));
                typelist.add( new topicnewsmenupage(mActivity,categories.data.get(1)));
                typelist.add( new picturenewsmenupage(mActivity,categories.data.get(2)));
                typelist.add( new interactnewsmenupage(mActivity,categories.data.get(3)));
            }

            @Override
            public void onFailure(HttpException e, String s)
            {
                Log.i("OnFailure",e.toString());
            }
        });
    }
    public View getrootv()
    {
        return rootv;
    }

    public void setNewsType(int i)
    {
        menupage page = typelist.get(i);
        page.initmRootView();
        page.initData();
        ll_page_content.removeAllViews();
        ll_page_content.addView(page.mRootView);
    }
}
