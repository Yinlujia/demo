package com.jsure.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter{

    public Context mContext;
    public List<Item> mDataList = new ArrayList<>();

    public ListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public Item getItem(int position) {
        if (mDataList == null) {
            return null;
        }
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setData(List<Item> itemList) {
        mDataList = itemList;
        notifyDataSetChanged();
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, null);
//        TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
//        TextView tv_time = (TextView) convertView.findViewById(R.id.tv_time);
//        TextView tv_content = (TextView) convertView.findViewById(R.id.tv_content);
//
//        Item item = getItem(position);
//        tv_title.setText(item.getTitle());
//        tv_time.setText(item.getTime());
//        tv_content.setText(item.getContent());
//
//        return convertView;
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Item item = getItem(position);
        viewHolder.tv_title.setText(item.getTitle());
        viewHolder.tv_time.setText(item.getTime());
        viewHolder.tv_content.setText(item.getContent());

        return convertView;
    }


    protected static class ViewHolder {
        TextView tv_title;
        TextView tv_time;
        TextView tv_content;

        public ViewHolder(View view) {
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            tv_time = (TextView) view.findViewById(R.id.tv_time);
            tv_content = (TextView) view.findViewById(R.id.tv_content);
        }
    }
}
