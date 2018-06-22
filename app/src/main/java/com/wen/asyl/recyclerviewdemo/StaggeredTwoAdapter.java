package com.wen.asyl.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：xx <br/>
 * Copyright (c) 2018<br/>
 * This program is protected by copyright laws <br/>
 * Date:2018-06-22 11:17
 *
 * @author 姜文莒
 * @version : 1.0
 */
public class StaggeredTwoAdapter extends SimpleAdapter {

    private List<Integer> mHeight;
    public StaggeredTwoAdapter(Context context, List<String> datas) {
        super(context,datas);
        mHeight=new ArrayList<>();
        for (int i=0;i<mDatas.size();i++){
            mHeight.add((int) (100+Math.random()*300));
        }
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height=mHeight.get(position);
        holder.itemView.setLayoutParams(layoutParams);
        holder.tv.setText(mDatas.get(position));
        setUpOnClicl(holder);
    }
}
