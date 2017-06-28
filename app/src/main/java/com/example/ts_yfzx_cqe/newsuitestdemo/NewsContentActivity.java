package com.example.ts_yfzx_cqe.newsuitestdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ts_yfzx_cqe.fragment.NewsContentFragment;

public class NewsContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager().
                findFragmentById(R.id.content_fragment);
        //刷新NewsContentFragment界面
        newsContentFragment.refreshNewsContent(title,content);
    }

    public static void actionStart(Context context,String title,String content){
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        context.startActivity(intent);

    }
}
