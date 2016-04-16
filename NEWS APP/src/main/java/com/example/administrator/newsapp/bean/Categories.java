package com.example.administrator.newsapp.bean;

import java.util.ArrayList;

    public class Categories
    {
        public  int retcode;
        public ArrayList<NewsTypeInfo> data;
        public  class NewsTypeInfo
        {
            public String title;
            public int type;
            public int id;
            public String url;
            public String url1;
            public ArrayList<ChildrenInfo>  children;
            public class ChildrenInfo
            {
                public int id;
                public String title;
                public int type;
                public String url;
            }

            @Override
            public String toString()
            {
                return "NewsTypeInfo{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", type=" + type +
                        ", url='" + url + '\'' +
                        ", url1='" + url1 + '\'' +
                        '}';
            }
        }

        @Override
        public String toString()
        {
            return "Categories{" +
                    "data=" + data +
                    ", retcode=" + retcode +
                    '}';
        }
    }
