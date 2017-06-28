package com.example.ts_yfzx_cqe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ts_yfzx_cqe.Bean.News;
import com.example.ts_yfzx_cqe.util.RecyclerViewDriver;
import com.example.ts_yfzx_cqe.newsuitestdemo.NewsContentActivity;
import com.example.ts_yfzx_cqe.newsuitestdemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by TS-YFZX-CQE on 2017/6/26.
 */
public class LeftFragment extends Fragment {

    private View view;
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private boolean isTwoPage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_left, container, false);

        initView();
        return view;
    }

    //制造假数据
    private List<News> getData() {
        List<News> mList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            News news = new News();
            news.setTitle("This is title " + i);
            news.setContent(getRandomLength("This is content " + i + " ! "));
            mList.add(news);
        }
        return mList;
    }

    private String getRandomLength(String str) {
        Random random = new Random();
        int length = random.nextInt(30);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< length; i++){
            sb.append(str);
        }
        return sb.toString();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mAdapter = new MyAdapter(getData());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        //设置RecyclerView的分割线
        mRecyclerView.addItemDecoration(new RecyclerViewDriver(getActivity(),RecyclerViewDriver.VERTICAL_LIST));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.right_layout) != null) {
            isTwoPage = true;
        } else {
            isTwoPage = false;
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private final List<News> mNewsList;

        public MyAdapter(List<News> mList) {
            mNewsList = mList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = mNewsList.get(holder.getAdapterPosition());
                    if (isTwoPage) {
                        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.content_fragment);
                        newsContentFragment.refreshNewsContent(news.getTitle(), news.getContent());
                    } else {
                        NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news = mNewsList.get(position);
            holder.title_tv.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView title_tv;

            public ViewHolder(View itemView) {
                super(itemView);
                title_tv = (TextView) itemView.findViewById(R.id.item_text);
            }
        }
    }
}