package com.example.administrator.newsapp.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 16-4-13.
 */
public class NewsDetail
{
    ArrayList<NewsInfo> data;
    int retcode;
    @Override
    public String toString()
    {
        return "NewsDetail" +
                "data=" + data +
                ", retcode=" + retcode;
    }

    class NewsInfo
    {
        String  countcommenturl ;
        String  more;
        String  title ;
        ArrayList<ArticleNews>  news;
        ArrayList<Topic>  topic;
        ArrayList<Topnews>  topnews;
        class ArticleNews
        {
            String comment;
        }
        class Topic
        {
            String title;
            String description;
        }

        class Topnews
        {
            String title;
            String topimage;
            @Override
            public String toString()
            {
                return "Topnews" +
                        "title='" + title + '\'' +
                        ", topimage='" + topimage + '\'';
            }
        }
    }
}
