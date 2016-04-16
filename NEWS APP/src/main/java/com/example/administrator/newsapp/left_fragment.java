package com.example.administrator.newsapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.newsapp.Page.newspage;
import com.example.administrator.newsapp.bean.Categories;


public class left_fragment extends Fragment
{
    private ListView lv_slidingmenu_type;
    private int currentPostion;
    Categories categories;
    private MyleftMenulistAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
         View view = inflater.inflate(R.layout.left_menu,null);
         final MainActivity homeActivity = (MainActivity) getActivity();
         final content_fragment contentFragment = homeActivity.getcontent_fragment();
         lv_slidingmenu_type = (ListView) view.findViewById(R.id.left_menu_type);
         lv_slidingmenu_type.setOnItemClickListener(new AdapterView.OnItemClickListener()
         {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                newspage newsPage = contentFragment.getnewspage();
                newsPage.setNewsType(position);
                homeActivity.setSlidingMenuToggle();
                currentPostion=position;
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    class MyleftMenulistAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return categories.data.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View view = View.inflate(getActivity(), R.layout.menuitem, null);
            final TextView tv_menulistitem_category = (TextView) view.findViewById(R.id.tv_menulistitem_category);
            tv_menulistitem_category.setText(categories.data.get(position).title);
            if (position==currentPostion)
            {
                tv_menulistitem_category.setEnabled(true);
            }
            return view;
        }
    }

    public void setCategories(Categories categories)
    {
        this.categories=categories;
        adapter = new MyleftMenulistAdapter();
        lv_slidingmenu_type.setAdapter(adapter);
    }
}
