package com.example.ts_yfzx_cqe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ts_yfzx_cqe.newsuitestdemo.R;


/**
 * Created by TS-YFZX-CQE on 2017/6/26.
 */
public class LeftFragmentTest extends Fragment{

    private View view;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_left,container,false);
        initView();
        return view;
    }

    private void initView() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        public MyAdapter() {

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
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