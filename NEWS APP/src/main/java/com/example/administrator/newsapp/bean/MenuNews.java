package com.example.administrator.newsapp.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-4-13.
 */
public class MenuNews
{
        public int retcode ;
        public MenuDetailData  data;
        public class MenuDetailData
        {
            public String countcommenturl;
            public String more;
            public ArrayList<NewsData> news;
            public class NewsData
            {
                public  String listimage;
                public  String pubdate;
                public  String title;
                public  String type;
                public  String url;
                public int   id ;
            }
            public String title;
            public List<topnewsData> topnews;
            public class topnewsData
            {
                public  String title;
                public  String type;
                public  String url;
                public  int    id ;
                public  String pubdate;
                public  String topimage;
            }
        }
}
