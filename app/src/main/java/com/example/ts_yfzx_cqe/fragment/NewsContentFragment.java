package com.example.ts_yfzx_cqe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ts_yfzx_cqe.newsuitestdemo.R;

/**
 * Created by TS-YFZX-CQE on 2017/6/26.
 */

public class NewsContentFragment extends Fragment {

    private View view;
    private TextView mTitle;
    private TextView mContent;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_layout,container,false);
        mTitle = (TextView) view.findViewById(R.id.content_title);
        mContent = (TextView) view.findViewById(R.id.content_content);
        return view;
    }

    public void refreshNewsContent(String title, String content){
        mTitle.setText(title);
        mContent.setText(content);
    }
}
