package com.wen.asyl.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StaggeredActivity extends Activity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private StaggeredAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initViews();
        mAdapter=new StaggeredAdapter(this,mDatas);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        //设置分割线
       // mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        mAdapter.setOnItemClickListener(new StaggeredAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(StaggeredActivity.this,"第"+position+"位置",Toast.LENGTH_SHORT).show();
                mAdapter.deleteData(position);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(StaggeredActivity.this,"长按第"+position+"位置",Toast.LENGTH_SHORT).show();
                mAdapter.deleteData(position);
            }
        });


    }

    private void initViews() {
        mRecyclerView= (RecyclerView) findViewById(R.id.rlv_listview);
    }

    private void initDatas() {
        mDatas=new ArrayList<>();
        for (int i=1;i<=50;i++){
            mDatas.add(i+"");
        }
    }
}
