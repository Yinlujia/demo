package com.jsure.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context mContext;
    List<Item> mDataList = new ArrayList<>();

    public MyAdapter(Context c) {
        mContext = c;
    }

    public void setData(List<Item> itemList) {
        mDataList = itemList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Item getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list, null);
        TextView tv_title = view.findViewById(R.id.tv_title);
        TextView tv_content = view.findViewById(R.id.tv_content);
        TextView tv_time = view.findViewById(R.id.tv_time);

        Item item = getItem(position);
        tv_title.setText(item.getTitle());
        tv_content.setText(item.getContent());
        tv_time.setText(item.getTime());

        return view;
    }
}
